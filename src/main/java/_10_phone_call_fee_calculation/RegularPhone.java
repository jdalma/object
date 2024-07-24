package _10_phone_call_fee_calculation;

import _02_movie.Money;

import java.time.Duration;
import java.util.List;

public class RegularPhone extends Phone {

    private final Money amount;
    private final Duration seconds;

    public RegularPhone(Money amount, Duration seconds) {
        super(0);
        this.amount = amount;
        this.seconds = seconds;
    }

    public RegularPhone(Money amount, Duration seconds, double taxRate) {
        super(taxRate);
        this.amount = amount;
        this.seconds = seconds;
    }

    @Override
    protected Money calculateCallFee(Call call) {
        return amount.times((double) call.getDuration().getSeconds() / seconds.getSeconds());
    }

    public Money getAmount() {
        return amount;
    }

    public Duration getSeconds() {
        return seconds;
    }
}
