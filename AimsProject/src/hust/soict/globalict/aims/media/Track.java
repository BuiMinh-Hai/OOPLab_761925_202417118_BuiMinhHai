package hust.soict.globalict.aims.media;

import hust.soict.globalict.aims.exception.PlayerException;

public class Track implements Playable {
    private String title;
    private int length;

    public String getTitle() { return title; }
    public int getLength() { return length; }

    public Track(String title, int length) {
        this.title = title;
        this.length = length;
    }

    @Override
    public void play() throws PlayerException {
        if (this.getLength() > 0) {
            System.out.println("Playing track: " + this.getTitle());
            System.out.println("Track length: " + this.getLength());
        } else {
            System.err.println("ERROR: Track length is non-positive!");
            throw new PlayerException("ERROR: Track length is non-positive!");
        }
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Track) {
            Track next = (Track) obj;
            return this.title.equals(next.title) && this.length == next.length;
        }
        return false;
    }
}