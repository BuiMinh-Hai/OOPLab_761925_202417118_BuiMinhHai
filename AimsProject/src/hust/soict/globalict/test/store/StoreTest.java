package hust.soict.globalict.test.store;

import hust.soict.globalict.aims.media.DigitalVideoDisc;
import hust.soict.globalict.aims.store.Store;

public class StoreTest {
    public static void main(String[] args) {
        // Khởi tạo cửa hàng
        Store store = new Store();

        // Tạo một số đĩa DVD
        DigitalVideoDisc dvd1 = new DigitalVideoDisc("The Lion King", "Animation", "Roger Allers", 87, 19.95f);
        DigitalVideoDisc dvd2 = new DigitalVideoDisc("Star Wars", "Science Fiction", "George Lucas", 87, 24.95f);
        DigitalVideoDisc dvd3 = new DigitalVideoDisc("Aladin", "Animation", 18.99f);

        // Test hàm addDVD
        System.out.println("--- Bắt đầu thêm đĩa vào Store ---");
        store.addMedia(dvd1);
        store.addMedia(dvd2);
        store.addMedia(dvd3);

        // Test hàm removeDVD
        System.out.println("\n--- Bắt đầu xóa đĩa khỏi Store ---");
        store.removeMedia(dvd2); // Xóa đĩa có trong cửa hàng
        store.removeMedia(dvd2); // Cố tình xóa lại đĩa vừa xóa xem có báo lỗi không
    }
}