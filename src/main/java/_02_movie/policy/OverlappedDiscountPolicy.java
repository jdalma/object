package _02_movie.policy;

import _02_movie.Money;
import _02_movie.Screening;
import _02_movie.movie.DiscountPolicy;

import java.util.List;

public class OverlappedDiscountPolicy implements DiscountPolicy {

    private final List<DiscountPolicy> discountPolicies;

    public OverlappedDiscountPolicy(DiscountPolicy ... discountPolicies) {
        this.discountPolicies = List.of(discountPolicies);
    }

    @Override
    public Money calculateDiscountAmount(Screening screening) {
        Money result = Money.ZERO;

        for (DiscountPolicy discountPolicy : discountPolicies) {
            result = result.plus(discountPolicy.calculateDiscountAmount(screening));
        }

        return result;
    }
}
