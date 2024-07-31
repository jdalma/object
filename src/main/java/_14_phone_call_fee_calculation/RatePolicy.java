package _14_phone_call_fee_calculation;

import _02_movie.Money;

public interface RatePolicy {
    Money calculateFee(Phone phone);
}
