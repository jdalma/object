package _02_movie.policy;

import _02_movie.Money;
import _02_movie.Screening;
import _02_movie.movie.DiscountPolicy;

public class NoneDiscountPolicy implements DiscountPolicy {

    @Override
    public Money calculateDiscountAmount(Screening screening) {
        return Money.ZERO;
    }
}
