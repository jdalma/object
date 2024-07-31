package _14_phone_call_fee_calculation.feerule;

import _14_phone_call_fee_calculation.Call;
import _14_phone_call_fee_calculation.ratepolicy.DateTimeInterval;
import _14_phone_call_fee_calculation.ratepolicy.FeeCondition;

import java.time.DayOfWeek;
import java.util.List;
import java.util.stream.Collectors;

public class DayOfWeekFeeCondition implements FeeCondition  {
    private final List<DayOfWeek> dayOfWeeks;

    public DayOfWeekFeeCondition(DayOfWeek ... dayOfWeeks) {
        this.dayOfWeeks = List.of(dayOfWeeks);
    }

    @Override
    public List<DateTimeInterval> findTimeIntervals(Call call) {
        return call.getInterval()
                .splitByDay()
                .stream()
                .filter(each -> dayOfWeeks.contains(each.getFrom().getDayOfWeek()))
                .collect(Collectors.toList());
    }
}
