package imc.shapes.model;

import imc.shapes.visitor.ShapeVisitor;

import java.math.BigDecimal;

public class Square implements Shape {

    public final double side;

    public Square(double side) {
        this.side = side;
    }

    @Override
    public void accept(ShapeVisitor visitor) {
        visitor.visit(this);
    }
}
