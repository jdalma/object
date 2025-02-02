package _02_movie.policy;

import _02_movie.Money;
import _02_movie.Screening;
import _02_movie.condition.DiscountCondition;
import _02_movie.movie.DiscountPolicy;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;

public abstract class DefaultDiscountPolicy implements DiscountPolicy {
    private final List<DiscountCondition> conditions;

    public DefaultDiscountPolicy(DiscountCondition ... conditions) {
        this.conditions = Arrays.asList(conditions);
    }

    @Override
    public Money calculateDiscountAmount(Screening screening) {
        checkPreCondition(screening);

        for (DiscountCondition each : conditions) {
            if (each.isSatisfiedBy(screening)) {
                return getDiscountAmount(screening);
            }
        }
        return Money.ZERO;
    }

    private void checkPreCondition(Screening screening) {
//        assert screening != null && screening.getWhenScreened().isAfter(LocalDateTime.now());
    }

    abstract protected Money getDiscountAmount(Screening screening);
}
