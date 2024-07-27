package _11_phone_call_fee_calculation;

import _02_movie.Money;

import java.time.Duration;

public class NightlyDiscountPolicy extends BasicRatePolicy {

    private static final int LATE_NIGHT_HOUR = 22;

    private final Money nightlyAmount;
    private final Money regularAmount;
    private final Duration seconds;

    public NightlyDiscountPolicy(Money nightlyAmount, Money regularAmount, Duration seconds) {
        this.nightlyAmount = nightlyAmount;
        this.regularAmount = regularAmount;
        this.seconds = seconds;
    }

    @Override
    public Money calculateCallFee(Call call) {
        if (call.getFrom().getHour() >= LATE_NIGHT_HOUR) {
            return nightlyAmount.times(getPercent(call));
        }
        return regularAmount.times(getPercent(call));
    }

    private double getPercent(Call call) {
        return (double) call.getDuration().getSeconds() / seconds.getSeconds();
    }
}
