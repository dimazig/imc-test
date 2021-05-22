package imc.shapes.visitor;

import imc.shapes.model.Circle;
import imc.shapes.model.ShapeSet;
import imc.shapes.model.Square;
import imc.shapes.model.Triangle;
import org.junit.jupiter.api.Test;

import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

class AreaVisitorTest {

    @Test
    void should_calculate_area_of_circle() {
        // given
        var circle = new Circle(10);
        var visitor = new AreaVisitor();

        // when
        circle.accept(visitor);

        // then
        assertEquals(314.16, visitor.area());
    }

    @Test
    void should_calculate_area_of_square() {
        // given
        var square = new Square(10);
        var visitor = new AreaVisitor();

        // when
        square.accept(visitor);

        // then
        assertEquals(100, visitor.area());
    }

    @Test
    void should_calculate_area_of_triangle() {
        // given
        var triangle = new Triangle(10, 10, 10);
        var visitor = new AreaVisitor();

        // when
        triangle.accept(visitor);

        // then
        assertEquals(43.3, visitor.area());
    }

    @Test
    void should_calculate_area_of_shape_set() {
        // given
        var set = new ShapeSet(Set.of(
                new Circle(10),
                new Square(10),
                new Triangle(10, 10, 10)
        ));

        // when
        var visitor = new AreaVisitor();
        set.accept(visitor);

        // then
        assertEquals(457.46, visitor.area());
    }
}