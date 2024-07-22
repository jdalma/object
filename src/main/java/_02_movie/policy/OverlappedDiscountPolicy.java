package _02_movie.policy;

import _02_movie.Money;
import _02_movie.Screening;

import java.util.Arrays;
import java.util.List;

public class OverlappedDiscountPolicy extends DefaultDiscountPolicy {

    private final List<DiscountPolicy> discountPolicies;

    public OverlappedDiscountPolicy(DiscountPolicy ... discountPolicies) {
        this.discountPolicies = List.of(discountPolicies);
    }

    @Override
    protected Money getDiscountAmount(Screening screening) {
        Money result = Money.ZERO;
        for (DiscountPolicy each : discountPolicies) {
            result = result.plus(each.calculateDiscountAmount(screening));
        }
        return result;
    }
}
