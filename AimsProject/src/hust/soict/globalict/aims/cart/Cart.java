package hust.soict.globalict.aims.cart;

import java.util.ArrayList;
import java.util.Collections;
import hust.soict.globalict.aims.media.Media;

public class Cart {
    public static final int MAX_NUMBERS_ORDERED = 20;
    // Chỉ sử dụng ArrayList để chứa mọi loại Media (DVD, Book, CD)
    private ArrayList<Media> itemsOrdered = new ArrayList<Media>();

    // Thêm một sản phẩm
    public void addMedia(Media media) {
        if (itemsOrdered.size() < MAX_NUMBERS_ORDERED) {
            if (!itemsOrdered.contains(media)) {
                itemsOrdered.add(media);
                System.out.println("The media " + media.getTitle() + " has been added.");
            } else {
                System.out.println("The media " + media.getTitle() + " is already in the cart.");
            }
        } else {
            System.out.println("The cart is full.");
        }
    }
    public void addMedia(Media[] mediaList) {
    for (Media m : mediaList) {
        addMedia(m);
    }
}

    // Xóa một sản phẩm
    public void removeMedia(Media media) {
        if (itemsOrdered.remove(media)) {
            System.out.println("The media " + media.getTitle() + " has been removed.");
        } else {
            System.out.println("The media " + media.getTitle() + " was not found.");
        }
    }

    // Tính tổng tiền
    public float totalCost() {
        float total = 0;
        for (Media m : itemsOrdered) {
            total += m.getCost();
        }
        return total;
    }

    // In giỏ hàng (Sử dụng đa hình qua toString)
    public void print() {
        System.out.println("***********************CART***********************");
        System.out.println("Ordered Items:");
        for (int i = 0; i < itemsOrdered.size(); i++) {
            System.out.println((i + 1) + ". " + itemsOrdered.get(i).toString());
        }
        System.out.println("Total cost: " + totalCost() + " $");
        System.out.println("***************************************************");
    }

    // Tìm kiếm theo ID
    public void searchById(int id) {
        boolean found = false;
        for (Media m : itemsOrdered) {
            if (m.getId() == id) {
                System.out.println("Found match: " + m.toString());
                found = true;
                break;
            }
        }
        if (!found) System.out.println("No match found for ID: " + id);
    }

    // Tìm kiếm theo Title
    public void searchByTitle(String title) {
        boolean found = false;
        for (Media m : itemsOrdered) {
            if (m.isMatch(title)) {
                System.out.println("Found match: " + m.toString());
                found = true;
            }
        }
        if (!found) System.out.println("No match found for title: " + title);
    }

    // Sắp xếp
    public void sortByTitle() {
        Collections.sort(itemsOrdered, Media.COMPARE_BY_TITLE_COST);
    }

    public void sortByCost() {
        Collections.sort(itemsOrdered, Media.COMPARE_BY_COST_TITLE);
    }
}