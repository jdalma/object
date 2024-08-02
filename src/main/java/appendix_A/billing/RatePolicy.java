package appendix_A.billing;

import _02_movie.Money;

import java.util.List;

public interface RatePolicy {
	Money calculateFee(List<Call> calls);
}
