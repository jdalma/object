package _14_phone_call_fee_calculation;

import _14_phone_call_fee_calculation.ratepolicy.DateTimeInterval;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.List;

public class Call {

    private final DateTimeInterval interval;

    public Call(DateTimeInterval interval) {
        this.interval = interval;
    }

    public Duration getDuration() {
        return interval.duration();
    }

    public DateTimeInterval getInterval() {
        return interval;
    }
}
