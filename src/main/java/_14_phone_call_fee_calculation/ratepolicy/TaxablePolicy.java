package _14_phone_call_fee_calculation.ratepolicy;

import _02_movie.Money;
import _14_phone_call_fee_calculation.RatePolicy;

public class TaxablePolicy extends AdditionalRatePolicy {
    private final double taxRatio;

    public TaxablePolicy(double taxRatio, RatePolicy next) {
        super(next);
        this.taxRatio = taxRatio;
    }

    @Override
    public Money afterCalculated(Money fee) {
        return fee.plus(fee.times(taxRatio));
    }
}
