package _14_phone_call_fee_calculation.feerule;

import _14_phone_call_fee_calculation.Call;
import _14_phone_call_fee_calculation.ratepolicy.DateTimeInterval;
import _14_phone_call_fee_calculation.ratepolicy.FeeCondition;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;
import java.util.stream.Collectors;

public class TimeOfDayFeeCondition implements FeeCondition {
    private final LocalTime from;
    private final LocalTime to;

    public TimeOfDayFeeCondition(LocalTime from, LocalTime to) {
        this.from = from;
        this.to = to;
    }

    @Override
    public List<DateTimeInterval> findTimeIntervals(Call call) {
        return call.getInterval().splitByDay()
                .stream()
                .filter(each -> from(each).isBefore(to(each)))
                .map(this::DateTimeInterval)
                .collect(Collectors.toList());
    }

    private LocalTime from(DateTimeInterval interval) {
        final LocalTime relative = interval.getFrom().toLocalTime();
        return relative.isBefore(from) ? from : relative;
    }

    private LocalTime to(DateTimeInterval interval) {
        final LocalTime relative = interval.getFrom().toLocalTime();
        return relative.isAfter(to) ? to : relative;
    }

    private DateTimeInterval DateTimeInterval(DateTimeInterval each) {
        return DateTimeInterval.of(
                LocalDateTime.of(each.getFrom().toLocalDate(), from(each)),
                LocalDateTime.of(each.getTo().toLocalDate(), to(each))
        );
    }
}
