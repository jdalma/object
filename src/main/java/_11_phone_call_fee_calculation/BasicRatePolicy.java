package _11_phone_call_fee_calculation;

import _02_movie.Money;

public abstract class BasicRatePolicy implements RatePolicy {

    @Override
    public Money calculateFee(Phone phone) {
        Money result = Money.ZERO;
        for(Call call : phone.getCalls()) {
            result.plus(calculateCallFee(call));
        }

        return result;
    }

    public abstract Money calculateCallFee(Call call);
}
