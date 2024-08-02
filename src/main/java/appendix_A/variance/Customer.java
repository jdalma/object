package appendix_A.variance;

import appendix_A.variance.book.Book;
import appendix_A.variance.publisher.IndependentPublisher;
import appendix_A.variance.store.BookStall;
import appendix_A.variance.store.MagazineStore;

public class Customer {

    private Book book;

    public void order(BookStall bookStall) {
        this.book = bookStall.sell(new IndependentPublisher());
    }

    public static void main(String[] args) {
        new Customer().order(new BookStall());
        new Customer().order(new MagazineStore());
    }
}
