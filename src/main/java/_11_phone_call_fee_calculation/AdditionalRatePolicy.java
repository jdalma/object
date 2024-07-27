package _11_phone_call_fee_calculation;

import _02_movie.Money;

public abstract class AdditionalRatePolicy implements RatePolicy {

    private final RatePolicy next;

    public AdditionalRatePolicy(RatePolicy next) {
        this.next = next;
    }

    @Override
    public Money calculateFee(Phone phone) {
        Money fee = next.calculateFee(phone);
        return afterCalculated(fee);
    }

    public abstract Money afterCalculated(Money fee);
}
