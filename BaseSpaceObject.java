import java.awt.Polygon;
import java.awt.Shape;
import java.awt.geom.AffineTransform;
import java.awt.geom.Area;

public class BaseSpaceObject implements SpaceObject {
    private SpaceCoord position;
    private SpaceCoord speed;
    private boolean isAlive = true;
    private BattleField universe;

    public BaseSpaceObject(BattleField universe) {
        this.universe = universe;
        this.position = new SpaceCoord(0, 0, 0);
        this.speed = new SpaceCoord(0, 0, 0);
        // this.shape = new Area(new Polygon(
        //     new int[] {30, 30, -30, -30},
        //     new int[] {30, -30, -30, 30},
        //     4
        // ));
    }

    public SpaceCoord getPosition() { return position; }
    public void setPosition(SpaceCoord position) { this.position = position; }

    public SpaceCoord getSpeed() { return speed; }
    public void setSpeed(SpaceCoord speed) { this.speed = speed; }

    public boolean isAlive() { return isAlive; }

    public void stepNext() {
        position.x += speed.x;
        position.y += speed.y;
        position.r += speed.r;
    }
    
    // ------ 
    protected Shape shape;

    public Shape getShape() {
        AffineTransform t = new AffineTransform();
        t.translate(position.x, position.y);
        t.rotate(position.r);

        return t.createTransformedShape(shape);
    }

}
