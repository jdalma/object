package _14_phone_call_fee_calculation;

import _02_movie.Money;
import _14_phone_call_fee_calculation.feerule.*;
import _14_phone_call_fee_calculation.ratepolicy.BasicRatePolicy;
import _14_phone_call_fee_calculation.ratepolicy.DateTimeInterval;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.time.*;
import java.util.List;

import static java.time.DayOfWeek.*;

@DisplayName("Phone 클래스")
class PhoneTest {
    @Nested
    @DisplayName("calculateCallFee 메소드")
    class Describe_calculateCallFee {

        FeeRule 고정요금_1초당_18원 = new FeeRule(
                new FixedFeeCondition(),
                new FeePerDuration(Money.wons(18), Duration.ofSeconds(1))
        );

        FeeRule 시간대별_09시부터_18시까지_1분당_5원 = new FeeRule(
                new TimeOfDayFeeCondition(
                        LocalTime.of(9, 0),
                        LocalTime.of(18, 0)),
                new FeePerDuration(Money.wons(5), Duration.ofMinutes(1))
        );

        FeeRule 요일별_월요일부터_수요일까지_10초당_10원 = new FeeRule(
                new DayOfWeekFeeCondition(MONDAY, TUESDAY, WEDNESDAY),
                new FeePerDuration(Money.wons(10), Duration.ofMinutes(10))
        );

        FeeRule 구간별_통화시작_3시간부터_2시간동안_1초당_30원 = new FeeRule(
                new DurationFeeCondition(Duration.ofHours(3), Duration.ofHours(5)),
                new FeePerDuration(Money.wons(30), Duration.ofSeconds(1))
        );

        final LocalDateTime 수요일_09시_30분 = LocalDateTime.of(LocalDate.of(2024, Month.JULY, 31), LocalTime.of(9, 30, 0, 0));
        final LocalDateTime 수요일_09시_33분 = LocalDateTime.of(LocalDate.of(2024, Month.JULY, 31), LocalTime.of(9, 33, 0, 0));
        final LocalDateTime 수요일_18시_00분 = LocalDateTime.of(LocalDate.of(2024, Month.JULY, 31), LocalTime.of(18, 0, 0, 0));

        @Test
        @DisplayName("고정 요금 1초당 18원")
        void fixed() {
            final Call call = new Call(DateTimeInterval.of(수요일_09시_30분, 수요일_09시_33분));
            final Phone phone = new Phone(new BasicRatePolicy(고정요금_1초당_18원), List.of(call));

            Assertions.assertThat(phone.calculateFee()).isEqualTo(Money.wons(3240));
        }
    }
}
