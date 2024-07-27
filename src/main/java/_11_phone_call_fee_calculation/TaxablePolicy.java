package _11_phone_call_fee_calculation;

import _02_movie.Money;

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
