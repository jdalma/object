package _14_phone_call_fee_calculation.ratepolicy;

import _02_movie.Money;
import _14_phone_call_fee_calculation.Phone;
import _14_phone_call_fee_calculation.RatePolicy;

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
