package section02.list.dto;

public class Music implements Comparable<Music> {
    private String title;
    private String artist;

    public Music() {
    }

    public Music(String title, String artist) {
        this.title = title;
        this.artist = artist;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getArtist() {
        return artist;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }

    @Override
    public String toString() {
        return "Music{" +
                "title='" + title + '\'' +
                ", artist='" + artist + '\'' +
                '}';
    }

    @Override
    public int compareTo(Music o) {
        /**
         * this에서 o를 뺸다고 생각하면 된다.
         * 만약 this가 더 크다면 결과가 양수일것이고, 더 작다면 음수를 반환할 것이다.

         */
        return this.title.compareTo(o.title);
    }
}
