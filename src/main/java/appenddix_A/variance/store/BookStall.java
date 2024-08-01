package appenddix_A.variance.store;

import appenddix_A.variance.book.Book;
import appenddix_A.variance.publisher.IndependentPublisher;
import appenddix_A.variance.publisher.Publisher;

public class BookStall {

    public Book sell(IndependentPublisher independentPublisher) {
        return new Book(independentPublisher);
    }
}
