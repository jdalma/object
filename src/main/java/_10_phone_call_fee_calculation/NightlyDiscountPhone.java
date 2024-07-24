package _10_phone_call_fee_calculation;

import _02_movie.Money;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class NightlyDiscountPhone {

    private static final int LATE_NIGHT_HOUR = 22;

    private final Money nightlyAmount;
    private final Money regularAmount;
    private final Duration seconds;
    private final List<Call> calls;

    public NightlyDiscountPhone(Money nightlyAmount, Money regularAmount, Duration seconds) {
        this.nightlyAmount = nightlyAmount;
        this.regularAmount = regularAmount;
        this.seconds = seconds;
        this.calls = new ArrayList<>();
    }

    public Money calculateFee() {
        Money result = Money.ZERO;

        for (Call call : calls) {
            if (call.getFrom().getHour() >= LATE_NIGHT_HOUR) {
                result = result.plus(
                    nightlyAmount.times((double) call.getDuration().getSeconds() / seconds.getSeconds())
                );
            } else {
                result = result.plus(
                    regularAmount.times((double) call.getDuration().getSeconds() / seconds.getSeconds())
                );
            }
        }

        return result;
    }
}
