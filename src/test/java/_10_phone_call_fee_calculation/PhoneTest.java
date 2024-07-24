package _10_phone_call_fee_calculation;

import _02_movie.Money;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.time.Duration;
import java.time.LocalDateTime;

@DisplayName("Phone 클래스")
class PhoneTest {
    @Nested
    @DisplayName("calculateCallFee 메소드")
    class Describe_calculateCallFee {

        @Nested
        @DisplayName("10초에 5원씩 부과되는 요금제에 가입했고")
        class Context_with_10sec_5won_phone {
            RegularPhone givenPhone() {
                return new RegularPhone(Money.wons(5), Duration.ofSeconds(10));
            }

            @Nested
            @DisplayName("3분짜리 통화를 했다면")
            class Context_with_1_min_call {

                Call getFirstCall() {
                    return new Call(
                        LocalDateTime.of(2024, 7, 24, 16, 37, 0),
                        LocalDateTime.of(2024, 7, 24, 16, 40, 0)
                    );
                }

                @Test
                @DisplayName("90원을 리턴한다")
                void it_returns_calculated_won() {
                    Assertions.assertThat(givenPhone().calculateCallFee(getFirstCall())).isEqualTo(Money.wons(90.0));
                }
            }
        }
    }
}
