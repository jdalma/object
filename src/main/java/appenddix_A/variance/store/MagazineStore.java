package appenddix_A.variance.store;

import appenddix_A.variance.book.Book;
import appenddix_A.variance.book.Magazine;
import appenddix_A.variance.publisher.IndependentPublisher;

public class MagazineStore extends BookStall {

    @Override
    public Book sell(IndependentPublisher independentPublisher) {
        return new Magazine(independentPublisher);
    }
}
