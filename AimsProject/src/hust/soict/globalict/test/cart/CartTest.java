package hust.soict.globalict.test.cart;

import hust.soict.globalict.aims.cart.Cart;
import hust.soict.globalict.aims.media.DigitalVideoDisc;

public class CartTest {
    public static void main(String[] args) {
        // 1. Khởi tạo giỏ hàng mới
        Cart cart = new Cart();

        // 2. Tạo các đối tượng DVD mới và thêm vào giỏ hàng
        DigitalVideoDisc dvd1 = new DigitalVideoDisc("The Lion King", "Animation", "Roger Allers", 87, 19.95f);
        cart.addMedia(dvd1);

        DigitalVideoDisc dvd2 = new DigitalVideoDisc("Star Wars", "Science Fiction", "George Lucas", 87, 24.95f);
        cart.addMedia(dvd2);

        DigitalVideoDisc dvd3 = new DigitalVideoDisc("Aladin", "Animation", 18.99f);
        cart.addMedia(dvd3);

        // 3. Kiểm tra hàm in giỏ hàng (phương thức print)
        cart.print();

        // 4. Kiểm tra các hàm tìm kiếm
        System.out.println("\n--- Testing Search by ID ---");
        // Thử tìm ID có tồn tại (DVD1 thường là ID 1)
        cart.searchById(1);
        // Thử tìm ID không tồn tại
        cart.searchById(10);

        System.out.println("\n--- Testing Search by Title ---");
        // Thử tìm đúng tên (không phân biệt hoa thường)
        cart.searchByTitle("star wars");
        // Thử tìm theo từ khóa một phần
        cart.searchByTitle("Lion");
        // Thử tìm tên không có trong giỏ
        cart.searchByTitle("Avatar");
    }
}