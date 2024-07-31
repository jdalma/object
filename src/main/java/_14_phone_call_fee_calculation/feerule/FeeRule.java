package _14_phone_call_fee_calculation.feerule;

import _02_movie.Money;
import _14_phone_call_fee_calculation.Call;
import _14_phone_call_fee_calculation.ratepolicy.FeeCondition;

public class FeeRule {
    private final FeeCondition feeCondition;
    private final FeePerDuration feePerDuration;

    public FeeRule(FeeCondition feeCondition, FeePerDuration feePerDuration) {
        this.feeCondition = feeCondition;
        this.feePerDuration = feePerDuration;
    }

    public Money calculateFee(Call call) {
        return feeCondition.findTimeIntervals(call)
                .stream()
                .map(feePerDuration::calculate)
                .reduce(Money.ZERO, Money::plus);
    }
}
