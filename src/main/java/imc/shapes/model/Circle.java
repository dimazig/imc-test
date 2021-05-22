package imc.shapes.model;

import imc.shapes.visitor.ShapeVisitor;

import java.math.BigDecimal;

public class Circle implements Shape {

    public final double radius;

    public Circle(double radius) {
        this.radius = radius;
    }

    @Override
    public void accept(ShapeVisitor visitor) {
        visitor.visit(this);
    }
}
