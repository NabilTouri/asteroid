import java.awt.geom.Rectangle2D;
import java.util.ArrayList;

public class BattleField {
    protected Rectangle2D.Double borders =
        new Rectangle2D.Double(-500, -500, 1000, 1000);
    protected ArrayList<SpaceObject> objectList = new ArrayList<>();
    protected SpaceShip spaceship;
    
    public BattleField() {
        // BaseSpaceObject o = new BaseSpaceObject(this);
        // o.setPosition(new SpaceCoord(0, 0, 0));
        // o.setSpeed(new SpaceCoord(1, 2, 0));
        spaceship = new SpaceShip(this);
        objectList.add(spaceship);
    }

    public SpaceShip getSpaceShip() { return spaceship;}

    public void stepNext() {
        for(SpaceObject o: objectList) {
            o.stepNext();
            applyClosedUniverse(o);
        }

    }

    protected void applyClosedUniverse(SpaceObject o) {
        SpaceCoord p = o.getPosition();
        if(p.x > borders.getMaxX())
            p.x = borders.getMinX();
        else if(p.x < borders.getMinX())
            p.x = borders.getMaxX();
        
        if(p.y > borders.getMaxY())
            p.y = borders.getMinY();
        else if(p.y < borders.getMinY())
            p.y = borders.getMaxY();

        o.setPosition(p);
    }


    public ArrayList<SpaceObject> listSpaceObjects() { return objectList; }
    
}