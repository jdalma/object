package _14_phone_call_fee_calculation.feerule;

import _02_movie.Money;
import _14_phone_call_fee_calculation.ratepolicy.DateTimeInterval;

import java.time.Duration;

public class FeePerDuration {
    private final Money fee;
    private final Duration duration;

    public FeePerDuration(Money fee, Duration duration) {
        this.fee = fee;
        this.duration = duration;
    }

    public Money calculate(DateTimeInterval interval) {
        double times = (double) interval.duration().toNanos() / duration.toNanos();
        return fee.times(Math.ceil(times));
    }
}
