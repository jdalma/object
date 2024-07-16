package _01_ticketsales;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("Audience 클래스")
class AudienceTest {

    final Long givenTicketFee = 100L;
    final Ticket givenTicket = new Ticket(givenTicketFee);


    @Nested
    @DisplayName("buy 메소드는")
    class Describe_buy_method {

        @Nested
        @DisplayName("초대장이 있는 경우")
        class Context_with_invitation {
            final Invitation given_invitation = new Invitation();
            final Bag given_bag = new Bag(100000L, given_invitation);

            private Audience given_초대장_있는_관람객() {
                return new Audience(given_bag);
            }

            @Test
            @DisplayName("관람객의 가방에 티켓을 추가하고, 0을 리턴한다.")
            void It_returns_0() {
                final Audience 관람객 = given_초대장_있는_관람객();
                final Long paid = 관람객.buy(givenTicket);

                Assertions.assertThat(paid).isEqualTo(0L);
                Assertions.assertThat(given_bag.hasTicket()).isTrue();
            }
        }

        @Nested
        @DisplayName("초대장이 없는 경우")
        class Context_without_invitation {
            final Bag given_bag = new Bag(100000L);
            private Audience given_초대장_없는_관람객() {
                return new Audience(given_bag);
            }

            @Test
            @DisplayName("관람객의 가방에 티켓을 추가하고, 지불한 티켓 값을 리턴한다.")
            void It_pus_a_ticket_into_bag() {
                final Long paid = given_초대장_없는_관람객().buy(givenTicket);

                Assertions.assertThat(paid).isEqualTo(givenTicketFee);
                Assertions.assertThat(given_bag.hasTicket()).isTrue();
            }
        }
    }


}
