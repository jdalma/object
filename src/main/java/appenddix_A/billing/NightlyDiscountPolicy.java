package appenddix_A.billing;

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
	protected Money calculateCallFee(Call call) {
        final double during = (double) call.getDuration().getSeconds() / seconds.getSeconds();

        if (call.getFrom().getHour() >= LATE_NIGHT_HOUR) {
            return nightlyAmount.times(during);
        }

        return regularAmount.times(during);
	}
}
