package _14_phone_call_fee_calculation.ratepolicy;

import _02_movie.Money;
import _14_phone_call_fee_calculation.Call;
import _14_phone_call_fee_calculation.Phone;
import _14_phone_call_fee_calculation.RatePolicy;
import _14_phone_call_fee_calculation.feerule.FeeRule;

import java.util.List;

public class BasicRatePolicy implements RatePolicy {

    private final List<FeeRule> feeRules;

    public BasicRatePolicy(FeeRule ... feeRules) {
        this.feeRules = List.of(feeRules);
    }

    @Override
    public Money calculateFee(Phone phone) {
        return phone.getCalls()
                .stream()
                .map(this::calculate)
                .reduce(Money.ZERO , Money::plus);

    }

    private Money calculate(Call call) {
        return feeRules.stream()
                .map(rule -> rule.calculateFee(call))
                .reduce(Money.ZERO, Money::plus);
    }


}
