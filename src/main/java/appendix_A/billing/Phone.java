package appendix_A.billing;

import java.util.List;

public class Phone {
    private final RatePolicy ratePolicy;
    private final List<Call> calls;

    public Phone(RatePolicy ratePolicy, List<Call> calls) {
        this.ratePolicy = ratePolicy;
        this.calls = calls;
    }

    public void call(Call call) {
        calls.add(call);
    }

    public Bill publishBill() {
        return new Bill(this, ratePolicy.calculateFee(calls));
    }
}
