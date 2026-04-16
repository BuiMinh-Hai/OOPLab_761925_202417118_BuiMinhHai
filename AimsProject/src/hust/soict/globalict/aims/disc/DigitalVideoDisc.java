package hust.soict.globalict.aims.disc;

public class DigitalVideoDisc {
    // Các thuộc tính cơ bản
    private String title;
    private String category;
    private String director;
    private int length;
    private float cost;

    private static int nbDigitalVideoDiscs = 0; 
    private int id; 

    // --- CÁC CONSTRUCTOR ---
    public DigitalVideoDisc(String title) {
        super();
        this.title = title;
        nbDigitalVideoDiscs++;
        this.id = nbDigitalVideoDiscs;
    }

    public DigitalVideoDisc(String category, String title, float cost) {
        super();
        this.category = category;
        this.title = title;
        this.cost = cost;
        nbDigitalVideoDiscs++;
        this.id = nbDigitalVideoDiscs;
    }

    public DigitalVideoDisc(String director, String category, String title, float cost) {
        super();
        this.director = director;
        this.category = category;
        this.title = title;
        this.cost = cost;
        nbDigitalVideoDiscs++;
        this.id = nbDigitalVideoDiscs;
    }

    public DigitalVideoDisc(String title, String category, String director, int length, float cost) {
        super();
        this.title = title;
        this.category = category;
        this.director = director;
        this.length = length;
        this.cost = cost;
        nbDigitalVideoDiscs++;
        this.id = nbDigitalVideoDiscs;
    }

    // --- GETTERS VÀ SETTERS ---
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getCategory() {
        return category;
    }

    public String getDirector() {
        return director;
    }

    public int getLength() {
        return length;
    }

    public float getCost() {
        return cost;
    }

    public int getId() {
        return id;
    }

    // --- CÁC PHƯƠNG THỨC MỚI CHO LAB 03 ---

    // Hàm trả về chuỗi thông tin định dạng chuẩn của DVD
    public String toString() {
        return "DVD - [" + this.title + "] - [" + this.category + "] - [" + this.director + "] - [" + this.length + "]: " + this.cost + " $";
    }

    // Hàm kiểm tra xem title đưa vào có khớp với title của đĩa không
    public boolean isMatch(String title) {
        // Kiểm tra an toàn để tránh lỗi NullPointerException
        if (this.title == null || title == null) {
            return false;
        }
        // So sánh 2 chuỗi (chuyển hết về chữ thường để so sánh không phân biệt hoa/thường)
        return this.title.toLowerCase().contains(title.toLowerCase());
    }
}