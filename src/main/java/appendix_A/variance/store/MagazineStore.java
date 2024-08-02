package appendix_A.variance.store;

import appendix_A.variance.book.Book;
import appendix_A.variance.book.Magazine;
import appendix_A.variance.publisher.IndependentPublisher;

public class MagazineStore extends BookStall {

    @Override
    public Book sell(IndependentPublisher independentPublisher) {
        return new Magazine(independentPublisher);
    }
}
