package hust.soict.globalict.aims.media;

import java.util.Comparator;

public class MediaComparatorByCostTitle implements Comparator<Media> {
    @Override
    public int compare(Media m1, Media m2) {
        // So sánh theo giá (Giảm dần)
        int costCompare = Float.compare(m2.getCost(), m1.getCost());
        if (costCompare != 0) {
            return costCompare;
        }
        // Nếu giá bằng nhau, so sánh theo tiêu đề (Alphabetical)
        return m1.getTitle().compareToIgnoreCase(m2.getTitle());
    }
}