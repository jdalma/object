package _11_phone_call_fee_calculation;

import _02_movie.Money;

import java.time.Duration;

public class RegularPolicy extends BasicRatePolicy {
    private Money amount;
    private Duration seconds;

    public RegularPolicy(Money amount, Duration seconds) {
        this.amount = amount;
        this.seconds = seconds;
    }

    @Override
    public Money calculateCallFee(Call call) {
        return amount.times((double) call.getDuration().getSeconds() / seconds.getSeconds());
    }
}
