package _14_phone_call_fee_calculation.feerule;

import _14_phone_call_fee_calculation.Call;
import _14_phone_call_fee_calculation.ratepolicy.DateTimeInterval;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.time.*;

@DisplayName("DurationFeeCondition")
class DurationFeeConditionTest {

    final LocalDateTime 수요일_09시_30분 = LocalDateTime.of(LocalDate.of(2024, Month.JULY, 31), LocalTime.of(9, 30, 0, 0));
    final LocalDateTime 수요일_18시_00분 = LocalDateTime.of(LocalDate.of(2024, Month.JULY, 31), LocalTime.of(18, 0, 0, 0));

    @Test
    void findTimeIntervals() {
        DurationFeeCondition condition = new DurationFeeCondition(
                Duration.ofHours(8),
                Duration.ofHours(9)
        );

        Call call = new Call(DateTimeInterval.of(수요일_09시_30분, 수요일_18시_00분));
        DateTimeInterval interval = condition.findTimeIntervals(call).get(0);

        Assertions.assertThat(interval).isEqualTo(DateTimeInterval.of(
            LocalDateTime.of(LocalDate.of(2024, Month.JULY, 31), LocalTime.of(17, 30, 0, 0)),
            LocalDateTime.of(LocalDate.of(2024, Month.JULY, 31), LocalTime.of(18, 0, 0, 0))
        ));
    }
}
