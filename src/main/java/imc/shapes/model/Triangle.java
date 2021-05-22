package imc.shapes.model;

import imc.shapes.visitor.ShapeVisitor;

import java.math.BigDecimal;

public class Triangle implements Shape {

    public final double side1;
    public final double side2;
    public final double side3;

    public Triangle(double side1, double side2, double side3) {
        this.side1 = side1;
        this.side2 = side2;
        this.side3 = side3;
    }

    @Override
    public void accept(ShapeVisitor visitor) {
        visitor.visit(this);
    }
}
