package hust.soict.globalict.aims.media;

import java.util.Comparator;

public abstract class Media {
    private int id;
    private String title;
    private String category;
    private float cost;

    // Các bộ so sánh để sắp xếp (Phần 17)
    public static final Comparator<Media> COMPARE_BY_TITLE_COST = new MediaComparatorByTitleCost();
    public static final Comparator<Media> COMPARE_BY_COST_TITLE = new MediaComparatorByCostTitle();

    // 1. THÊM CONSTRUCTOR RỖNG (Để các lớp con gọi super() không bị lỗi)
    public Media() {
    }

    public Media(int id, String title, String category, float cost) {
        this.id = id;
        this.title = title;
        this.category = category;
        this.cost = cost;
    }

    // 2. GETTERS
    public int getId() { return id; }
    public String getTitle() { return title; }
    public String getCategory() { return category; }
    public float getCost() { return cost; }

    // 3. THÊM SETTERS (Để các lớp con có thể gán giá trị)
    public void setId(int id) { this.id = id; }
    public void setTitle(String title) { this.title = title; }
    public void setCategory(String category) { this.category = category; }
    public void setCost(float cost) { this.cost = cost; }

    // Override equals() để kiểm tra trùng lặp dựa trên title (Phần 15)
    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Media) {
            Media other = (Media) obj;
            return this.title != null && this.title.equalsIgnoreCase(other.getTitle());
        }
        return false;
    }

    public boolean isMatch(String title) {
        // Thêm kiểm tra null để tránh lỗi NullPointerException
        if (this.title == null || title == null) return false;
        return this.title.toLowerCase().contains(title.toLowerCase());
    }
}