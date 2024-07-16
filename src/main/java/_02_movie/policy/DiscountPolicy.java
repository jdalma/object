package _02_movie.policy;

import _02_movie.Money;
import _02_movie.Screening;
import _02_movie.condition.DiscountCondition;

import java.util.Arrays;
import java.util.List;

public abstract class DiscountPolicy {
    private final List<DiscountCondition> conditions;

    public DiscountPolicy(DiscountCondition ... conditions) {
        this.conditions = Arrays.asList(conditions);
    }

    public Money calculateDiscountAmount(Screening screening) {
        for (DiscountCondition each : conditions) {
            if (each.isSatisfiedBy(screening)) {
                return getDiscountAmount(screening);
            }
        }
        return Money.ZERO;
    }

    abstract protected Money getDiscountAmount(Screening screening);
}
