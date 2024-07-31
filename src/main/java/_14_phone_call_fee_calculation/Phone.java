package _14_phone_call_fee_calculation;

import _02_movie.Money;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Phone {

    private final RatePolicy ratePolicy;
    private final List<Call> calls;

    protected Phone(RatePolicy ratePolicy, List<Call> calls) {
        this.ratePolicy = ratePolicy;
        this.calls = calls;
    }

    public Money calculateFee() {
        return ratePolicy.calculateFee(this);
    }

    public List<Call> getCalls() {
        return Collections.unmodifiableList(calls);
    }
}
