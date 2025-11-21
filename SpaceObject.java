import java.awt.Shape;

public interface SpaceObject {
    SpaceCoord getPosition();
    SpaceCoord getSpeed();
    void setPosition(SpaceCoord p);
    void setSpeed(SpaceCoord s);
    boolean isAlive();
    void stepNext();

    Shape getShape();
}