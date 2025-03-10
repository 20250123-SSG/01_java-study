package practice2.mvc.dto;

import java.util.Objects;

public class AniBook extends Book {
    private int accessAge;

    public AniBook() {
    }

    public AniBook(String title, String author, String publisher, int accessAge) {
        super(title, author, publisher);
        this.accessAge = accessAge;
    }

    public int getAccessAge() {
        return accessAge;
    }

    public void setAccessAge(int accessAge) {
        this.accessAge = accessAge;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        AniBook aniBook = (AniBook) o;
        return accessAge == aniBook.accessAge;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), accessAge);
    }

    @Override
    public String toString() {
        return "AniBook{" +
                super.toString() +
                "accessAge=" + accessAge +
                '}';
    }

}
