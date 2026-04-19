package hust.soict.globalict.aims.media;

import java.util.Comparator;

public class MediaComparatorByTitleCost implements Comparator<Media> {
    @Override
    public int compare(Media m1, Media m2) {
        // So sánh theo tiêu đề (Alphabetical)
        int titleCompare = m1.getTitle().compareToIgnoreCase(m2.getTitle());
        if (titleCompare != 0) {
            return titleCompare;
        }
        // Nếu tiêu đề giống nhau, so sánh theo giá (Giảm dần)
        return Float.compare(m2.getCost(), m1.getCost());
    }
}