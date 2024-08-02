package appendix_A.variance.store;

import appendix_A.variance.book.Book;
import appendix_A.variance.publisher.IndependentPublisher;

public class BookStall {

    public Book sell(IndependentPublisher independentPublisher) {
        return new Book(independentPublisher);
    }
}
