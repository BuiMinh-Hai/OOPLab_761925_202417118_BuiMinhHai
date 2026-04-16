package hust.soict.globalict.aims;
import hust.soict.globalict.aims.cart.Cart;
import hust.soict.globalict.aims.disc.DigitalVideoDisc;

public class Aims {

    public static void main(String[] args) {
        
        Cart anOrder = new Cart();

        DigitalVideoDisc dvd1 = new DigitalVideoDisc("The Lion King", "Animation", "Roger Allers", 87, 19.95f);
        DigitalVideoDisc dvd2 = new DigitalVideoDisc("Star Wars", "Science Fiction", "George Lucas", 87, 24.95f);
        DigitalVideoDisc dvd3 = new DigitalVideoDisc("Aladin", "Animation", 18.99f);
        DigitalVideoDisc dvd4 = new DigitalVideoDisc("The Matrix", "Action", 20.00f);
        DigitalVideoDisc dvd5 = new DigitalVideoDisc("Inception", "Sci-Fi", 22.50f);

        DigitalVideoDisc[] dvdArray = {dvd1, dvd2}; // Tạo mảng chứa dvd1 và dvd2
        anOrder.addDigitalVideoDisc(dvdArray);      // Gọi hàm nạp chồng thứ nhất
        anOrder.printCart();

        anOrder.addDigitalVideoDisc(dvd4, dvd5);    // Gọi hàm nạp chồng thứ hai
        anOrder.printCart();


        // Thử xóa đĩa dvd2 (Star Wars)
        anOrder.removeDigitalVideoDisc(dvd2);
        
        // In lại giỏ hàng để xác nhận đĩa dvd2 đã biến mất và tổng tiền được tính lại
        anOrder.printCart();

        // Kiểm tra ID tự động cấp phát 
        System.out.println("ID 1 (" + dvd1.getTitle() + ") : " + dvd1.getId());
        System.out.println("ID 2 (" + dvd2.getTitle() + ") : " + dvd2.getId());
        System.out.println("ID 3 (" + dvd3.getTitle() + ") : " + dvd3.getId());
    }
}