package hust.soict.globalict.aims.media;

public class DigitalVideoDisc extends Media implements Playable{
    // CHỈ GIỮ LẠI các thuộc tính riêng biệt của DVD
    private String director;
    private int length;

    // Bộ đếm ID tự động
    private static int nbDigitalVideoDiscs = 0; 

    // --- CÁC CONSTRUCTOR ---
    public DigitalVideoDisc(String title) {
        super();
        this.setTitle(title); // Sử dụng setter kế thừa từ Media
        nbDigitalVideoDiscs++;
        this.setId(nbDigitalVideoDiscs);
    }

    public DigitalVideoDisc(String category, String title, float cost) {
        super();
        this.setCategory(category);
        this.setTitle(title);
        this.setCost(cost);
        nbDigitalVideoDiscs++;
        this.setId(nbDigitalVideoDiscs);
    }

    public DigitalVideoDisc(String director, String category, String title, float cost) {
        super();
        this.director = director;
        this.setCategory(category);
        this.setTitle(title);
        this.setCost(cost);
        nbDigitalVideoDiscs++;
        this.setId(nbDigitalVideoDiscs);
    }

    public DigitalVideoDisc(String title, String category, String director, int length, float cost) {
        super();
        this.setTitle(title);
        this.setCategory(category);
        this.director = director;
        this.length = length;
        this.setCost(cost);
        nbDigitalVideoDiscs++;
        this.setId(nbDigitalVideoDiscs);
    }

    // --- GETTERS VÀ SETTERS ---
    // Chỉ viết getter/setter cho các thuộc tính riêng của DVD
    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    // --- CÁC PHƯƠNG THỨC MỚI CHO LAB 03 ---

    // Hàm trả về chuỗi thông tin định dạng chuẩn của DVD
    @Override
    public String toString() {
        // Dùng getTitle(), getCategory(), getCost() thay vì this.title...
        return "DVD - [" + this.getTitle() + "] - [" + this.getCategory() + "] - [" + this.director + "] - [" + this.length + "]: " + this.getCost() + " $";
    }

    // Hàm kiểm tra xem title đưa vào có khớp với title của đĩa không
    public boolean isMatch(String title) {
        // Kiểm tra an toàn để tránh lỗi NullPointerException
        if (this.getTitle() == null || title == null) {
            return false;
        }
        // So sánh 2 chuỗi (chuyển hết về chữ thường để so sánh không phân biệt hoa/thường)
        return this.getTitle().toLowerCase().contains(title.toLowerCase());
    }
    @Override
    public void play() {
        System.out.println("Playing DVD: " + this.getTitle());
        System.out.println("DVD length: " + this.getLength());
    }
}