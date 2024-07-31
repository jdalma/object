package _11_phone_call_fee_calculation;

import _02_movie.Money;

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