package hust.soict.globalict.aims.store;

import java.util.ArrayList;
import hust.soict.globalict.aims.media.Media;

public class Store {
    private ArrayList<Media> itemsInStore = new ArrayList<Media>();

    public void addMedia(Media media) {
        if (!itemsInStore.contains(media)) {
            itemsInStore.add(media);
            System.out.println("Đã thêm '" + media.getTitle() + "' vào cửa hàng.");
        } else {
            System.out.println("Sản phẩm '" + media.getTitle() + "' đã có sẵn trong cửa hàng.");
        }
    }

    public void removeMedia(Media media) {
        if (itemsInStore.remove(media)) {
            System.out.println("Đã xóa '" + media.getTitle() + "' khỏi cửa hàng.");
        } else {
            System.out.println("Không tìm thấy sản phẩm '" + media.getTitle() + "'.");
        }
    }

    public void print() {
        System.out.println("********************STORE INVENTORY********************");
        if (itemsInStore.isEmpty()) {
            System.out.println("Cửa hàng đang trống.");
        } else {
            for (Media m : itemsInStore) {
                System.out.println(m.toString());
            }
        }
        System.out.println("*******************************************************");
    }

    // Hàm phụ trợ tìm kiếm Media theo tên (Rất cần cho Menu ở Yêu cầu 18)
    public Media searchByTitle(String title) {
        for (Media m : itemsInStore) {
            if (m.isMatch(title)) {
                return m;
            }
        }
        return null;
    }
}