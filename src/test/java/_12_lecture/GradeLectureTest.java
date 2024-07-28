package _12_lecture;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

@DisplayName("GradeLecture")
class GradeLectureTest {
    Lecture givenLecture() {
        return new GradeLecture(
                70,
                "객체지향 프로그래밍",
                Arrays.asList(81, 95, 75, 50, 45, 98),
                Arrays.asList(
                        new Grade("A", 100, 95),
                        new Grade("B", 94, 80),
                        new Grade("C", 79, 70),
                        new Grade("D", 69, 50),
                        new Grade("F", 49, 0)));
    }

    GradeLecture givenGradeLecture() {
        return new GradeLecture(
                70,
                "객체지향 프로그래밍",
                Arrays.asList(81, 95, 75, 50, 45, 98),
                Arrays.asList(
                        new Grade("A", 100, 95),
                        new Grade("B", 94, 80),
                        new Grade("C", 79, 70),
                        new Grade("D", 69, 50),
                        new Grade("F", 49, 0)));
    }

    @Nested
    @DisplayName("evaluate 메소드")
    class Describe_evaluate {

        @Test
        @DisplayName("이수한 학생의 수와 낙제한 학생의 수를 표현하는 문자열을 리턴한다")
        void it_returns_formatted_string() {
            final String result = givenLecture().evaluate();
            final String expect = "Pass: 4 Fail: 2, A:2 B:1 C:1 D:1 F:1";

            Assertions.assertThat(result).isEqualTo(expect);
        }
    }

    @Nested
    @DisplayName("average 메서드")
    class Describe_average {

        @Test
        void it_returns_grade_average() {
            Assertions.assertThat(givenGradeLecture().average("A"))
                    .isEqualTo(96.5);
        }
    }

    @Nested
    @DisplayName("stats 메서드")
    class Describe_stats {

        @Test
        void it_returns_Grade() {
            Assertions.assertThat(givenGradeLecture().stats()).isEqualTo("Title: 객체지향 프로그래밍, Evaluation Method: Grade");
            Assertions.assertThat(givenLecture().stats()).isEqualTo("Title: 객체지향 프로그래밍, Evaluation Method: Grade");
        }
    }

}
