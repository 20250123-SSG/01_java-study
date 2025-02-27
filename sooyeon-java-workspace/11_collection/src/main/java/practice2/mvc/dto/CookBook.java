package practice2.mvc.dto;

import java.util.Objects;

public class CookBook extends Book {

    private boolean coupon;

    public CookBook() {
    }

    public CookBook(String title, String author, String publisher, boolean coupon) {
        super(title, author, publisher);
        this.coupon = coupon;
    }

    public boolean isCoupon() {
        return coupon;
    }

    public void setCoupon(boolean coupon) {
        this.coupon = coupon;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        CookBook cookBook = (CookBook) o;
        return coupon == cookBook.coupon;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), coupon);
    }

    @Override
    public String toString() {
        return "CookBook{" +
                super.toString() +
                "coupon=" + coupon +
                '}';
    }

}
