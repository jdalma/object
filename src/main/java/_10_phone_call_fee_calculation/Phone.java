package _10_phone_call_fee_calculation;

import _02_movie.Money;

import java.util.ArrayList;
import java.util.List;

public abstract class Phone {

    private final double taxRate;
    private final List<Call> calls;

    protected Phone(double taxRate) {
        this.taxRate = taxRate;
        this.calls = new ArrayList<>();
    }

    public Money calculateFee() {
        Money result = Money.ZERO;

        for (Call call : calls) {
            result = result.plus(calculateCallFee(call));
        }

        return result.plus(result.times(taxRate));
    }
    abstract protected Money calculateCallFee(Call call);
}
