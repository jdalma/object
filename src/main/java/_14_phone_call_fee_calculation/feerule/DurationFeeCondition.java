package _14_phone_call_fee_calculation.feerule;

import _14_phone_call_fee_calculation.Call;
import _14_phone_call_fee_calculation.ratepolicy.DateTimeInterval;
import _14_phone_call_fee_calculation.ratepolicy.FeeCondition;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class DurationFeeCondition implements FeeCondition {
    private final Duration from;
    private final Duration to;

    public DurationFeeCondition(Duration from, Duration to) {
        this.from = from;
        this.to = to;
    }

    @Override
    public List<DateTimeInterval> findTimeIntervals(Call call) {
        final DateTimeInterval relativeInterval = call.getInterval();
        if (relativeInterval.duration().compareTo(from) < 0) {
            return Collections.emptyList();
        }

        final LocalDateTime calculatedTo = relativeInterval.duration().compareTo(to) > 0 ?
                relativeInterval.getFrom().plus(to) :
                relativeInterval.getTo();

        return List.of(
                DateTimeInterval.of(relativeInterval.getFrom().plus(from), calculatedTo)
        );
    }
}
