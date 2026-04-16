package hust.soict.globalict.aims.store;

import hust.soict.globalict.aims.disc.DigitalVideoDisc;

public class Store {
    // Giả sử cửa hàng chứa tối đa 50 đĩa trên kệ
    public static final int MAX_ITEMS_IN_STORE = 50;
    private DigitalVideoDisc itemsInStore[] = new DigitalVideoDisc[MAX_ITEMS_IN_STORE]; // Mảng chứa đĩa của cửa hàng [cite: 842]
    private int qtyInStore = 0;

    // Thêm đĩa vào cửa hàng [cite: 843]
    public void addDVD(DigitalVideoDisc dvd) {
        if (qtyInStore < MAX_ITEMS_IN_STORE) {
            itemsInStore[qtyInStore] = dvd;
            qtyInStore++;
            System.out.println("The DVD '" + dvd.getTitle() + "' has been added to the store.");
        } else {
            System.out.println("The store is full! Cannot add more DVDs.");
        }
    }

    // Xóa đĩa khỏi cửa hàng [cite: 843]
    public void removeDVD(DigitalVideoDisc dvd) {
        boolean found = false;
        for (int i = 0; i < qtyInStore; i++) {
            if (itemsInStore[i] == dvd) {
                found = true;
                // Dồn các phần tử phía sau lên trước để lấp chỗ trống
                for (int j = i; j < qtyInStore - 1; j++) {
                    itemsInStore[j] = itemsInStore[j + 1];
                }
                itemsInStore[qtyInStore - 1] = null;
                qtyInStore--;
                System.out.println("The DVD '" + dvd.getTitle() + "' has been removed from the store.");
                break;
            }
        }
        if (!found) {
            System.out.println("The DVD '" + dvd.getTitle() + "' is not found in the store.");
        }
    }
}