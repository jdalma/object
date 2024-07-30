package _13_shape;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class RectangleTest {

    @Test
    @DisplayName("Rectangle은 너비와 높이 변경에 대한 행위가 클라이언트 관점에서 만족한다.")
    void rectangleGetArea() {
        final Rectangle rectangle = new Rectangle(3, 5, 10, 20);

        Assertions.assertThat(rectangle.getArea()).isEqualTo(200);

        resize(rectangle, 30, 50);

        Assertions.assertThat(rectangle.getArea()).isEqualTo(1500);
    }

    @Test
    @DisplayName("Square은 너비와 높이 변경에 대한 행위가 클라이언트 관점에서 만족하지 못한다.")
    void squareGetArea() {
        final Rectangle rectangle = new Square(3, 5, 10);

        Assertions.assertThat(rectangle.getArea()).isEqualTo(100);

        resize(rectangle, 30, 50);

        Assertions.assertThat(rectangle.getArea()).isEqualTo(2500);
    }

    private void resize(Rectangle rectangle, int width, int height) {
        rectangle.setWidth(width);
        rectangle.setHeight(height);
    }
}
