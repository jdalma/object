package _06_command_query;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.time.DayOfWeek;
import java.time.Duration;
import java.time.LocalDateTime;
import java.time.LocalTime;

import static org.junit.jupiter.api.Assertions.*;

class EventTest {

    @Test
    void isSatisfied() {
        RecurringSchedule schedule = new RecurringSchedule(
                "회의",
                DayOfWeek.WEDNESDAY,
                LocalTime.of(10, 30),
                Duration.ofMinutes(30)
        );
        Event meeting = new Event(
                "회의",
                LocalDateTime.of(2019, 5, 8, 10, 30),
                Duration.ofMinutes(30)
        );

        Assertions.assertThat(meeting.isSatisfied(schedule)).isTrue();
    }

    @Test
    void reschedule() {
        RecurringSchedule schedule = new RecurringSchedule(
                "회의",
                DayOfWeek.WEDNESDAY,
                LocalTime.of(10, 30),
                Duration.ofMinutes(30)
        );
        Event meeting = new Event(
                "회의",
                LocalDateTime.of(2019, 5, 2, 10, 30),
                Duration.ofMinutes(30)
        );

        Assertions.assertThat(meeting.isSatisfied(schedule)).isFalse();

        meeting.reschedule(schedule);
        Assertions.assertThat(meeting.isSatisfied(schedule)).isTrue();
    }
}
