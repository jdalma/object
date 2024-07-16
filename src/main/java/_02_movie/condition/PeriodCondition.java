package _02_movie.condition;

import _02_movie.Screening;

import java.time.DayOfWeek;
import java.time.LocalTime;

public class PeriodCondition implements DiscountCondition {

    private final DayOfWeek dayOfWeek;
    private final LocalTime startTime;
    private final LocalTime endTime;

    public PeriodCondition(DayOfWeek dayOfWeek, LocalTime startTime, LocalTime endTime) {
        this.dayOfWeek = dayOfWeek;
        this.startTime = startTime;
        this.endTime = endTime;
    }

    @Override
    public boolean isSatisfiedBy(Screening screening) {
        final LocalTime screeningStartTime = screening.getWhenScreened().toLocalTime();
        return screening.getWhenScreened().getDayOfWeek().equals(dayOfWeek) &&
                !startTime.isAfter(screeningStartTime) &&
                !endTime.isBefore(screeningStartTime);
    }
}
