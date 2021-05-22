package imc.shapes.model;

import imc.shapes.visitor.ShapeVisitor;

public interface Shape {

    void accept(ShapeVisitor visitor);

}
