

public class Aims {

    public static void main(String[] args) {
        
        Cart anOrder = new Cart();

        DigitalVideoDisc dvd1 = new DigitalVideoDisc("The Lion King", "Animation", "Roger Allers", 87, 19.95f);
        anOrder.addDigitalVideoDisc(dvd1);

        DigitalVideoDisc dvd2 = new DigitalVideoDisc("Star Wars", "Science Fiction", "George Lucas", 87, 24.95f);
        anOrder.addDigitalVideoDisc(dvd2);

        DigitalVideoDisc dvd3 = new DigitalVideoDisc("Aladin", "Animation", 18.99f);
        anOrder.addDigitalVideoDisc(dvd3);

        // In danh sách đĩa và tổng tiền ra màn hình
        anOrder.printCart();

        // Thử xóa đĩa dvd2 (Star Wars)
        anOrder.removeDigitalVideoDisc(dvd2);
        
        // In lại giỏ hàng để xác nhận đĩa dvd2 đã biến mất và tổng tiền được tính lại
        anOrder.printCart();
    }
}