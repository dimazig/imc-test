package imc.shapes.model;

import imc.shapes.visitor.ShapeVisitor;

import java.util.Collections;
import java.util.Set;

import static java.util.Collections.unmodifiableSet;

public class ShapeSet implements Shape {

    public final Set<Shape> shapes;

    public ShapeSet(Set<Shape> shapes) {
        this.shapes = unmodifiableSet(shapes);
    }

    @Override
    public void accept(ShapeVisitor visitor) {
        shapes.forEach(shape -> shape.accept(visitor));
    }
}
