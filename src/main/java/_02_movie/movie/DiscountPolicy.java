package _02_movie.movie;

import _02_movie.Money;
import _02_movie.Screening;

public interface DiscountPolicy {
    Money calculateDiscountAmount(Screening screening);
}
