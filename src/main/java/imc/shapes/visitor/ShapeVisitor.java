package imc.shapes.visitor;

import imc.shapes.model.Circle;
import imc.shapes.model.Square;
import imc.shapes.model.Triangle;

public interface ShapeVisitor {

    void visit(Circle circle);

    void visit(Square square);

    void visit(Triangle triangle) ;
}
