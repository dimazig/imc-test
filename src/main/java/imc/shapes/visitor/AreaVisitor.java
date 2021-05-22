package imc.shapes.visitor;

import imc.shapes.model.Circle;
import imc.shapes.model.Square;
import imc.shapes.model.Triangle;

import java.math.BigDecimal;

import static java.lang.Math.PI;
import static java.math.RoundingMode.HALF_UP;

public class AreaVisitor implements ShapeVisitor {

    public static final int SCALE = 2;

    private double area = 0;

    @Override
    public void visit(Circle circle) {
        area += PI * circle.radius * circle.radius;
    }

    @Override
    public void visit(Square square) {
        area += square.side * square.side;
    }

    @Override
    public void visit(Triangle triangle) {
        final var p = (triangle.side1 + triangle.side2 + triangle.side3) / 2;
        area += Math.sqrt(p * (p - triangle.side1) * (p - triangle.side2) * (p - triangle.side3));
    }

    public double area() {
        return BigDecimal.valueOf(area).setScale(SCALE, HALF_UP).doubleValue();
    }
}
