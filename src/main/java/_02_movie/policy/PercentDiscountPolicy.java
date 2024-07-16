package _02_movie.policy;

import _02_movie.Money;
import _02_movie.Screening;
import _02_movie.condition.DiscountCondition;

public class PercentDiscountPolicy extends DiscountPolicy {
    private final Double percent;

    public PercentDiscountPolicy(Double percent, DiscountCondition... conditions) {
        super(conditions);
        this.percent = percent;
    }

    @Override
    protected Money getDiscountAmount(Screening screening) {
        return screening.getMovieFee().times(percent);
    }
}
