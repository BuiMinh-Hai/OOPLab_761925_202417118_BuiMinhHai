package hust.soict.globalict.aims.media;

public class Disc extends Media {
    private int length;
    private String director;

    public int getLength() { return length; }
    public String getDirector() { return director; }

    public Disc(int id, String title, String category, float cost, int length, String director) {
        super(id, title, category, cost);
        if (length < 0) {
            throw new IllegalArgumentException("Length cannot be negative!");
        }
        this.length = length;
        this.director = director;
    }
}