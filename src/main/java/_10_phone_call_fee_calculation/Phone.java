package _10_phone_call_fee_calculation;

import _02_movie.Money;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class Phone {

    private final Money amount;
    private final Duration seconds;
    private final List<Call> calls;

    public Phone(Money amount, Duration seconds) {
        this.amount = amount;
        this.seconds = seconds;
        this.calls = new ArrayList<>();
    }

    public void call(Call call) {
        this.calls.add(call);
    }

    public List<Call> getCalls() {
        return calls.stream().toList();
    }

    public Money getAmount() {
        return amount;
    }

    public Duration getSeconds() {
        return seconds;
    }

    public Money calculateFee() {
        Money result = Money.ZERO;

        for (Call call : calls) {
            Money calc = amount.times((double) call.getDuration().getSeconds() / seconds.getSeconds());
            result = result.plus(calc);
        }

        return result;
    }
}
