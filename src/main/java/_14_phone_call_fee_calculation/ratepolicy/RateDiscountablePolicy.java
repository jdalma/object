package _14_phone_call_fee_calculation.ratepolicy;

import _02_movie.Money;
import _14_phone_call_fee_calculation.RatePolicy;

public class RateDiscountablePolicy extends AdditionalRatePolicy {
    private final Money discountAmount;

    public RateDiscountablePolicy(Money discountAmount, RatePolicy next) {
        super(next);
        this.discountAmount = discountAmount;
    }

    @Override
    public Money afterCalculated(Money fee) {
        return fee.minus(discountAmount);
    }
}
