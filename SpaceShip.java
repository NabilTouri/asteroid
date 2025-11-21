import java.awt.Polygon;
import java.awt.geom.Area;

public class SpaceShip extends BaseSpaceObject {

    public SpaceShip(BattleField universe) {
        super(universe);
        // Customize the shape for the spaceship
        this.shape = new Area(new Polygon(
            new int[] {-30, 30, -30},
            new int[] {15, 0, -15},
            3
            ));

        this.getPosition().r = Math.PI / 2;

        

        

    }

    public void turn(double r) {
            getPosition().r += r;
    }

    public void accelerate(double a) {
        // Calcola la direzione dell'accelerazione basata sull'angolo di rotazione
        double dx = Math.cos(getPosition().r) * a;
        double dy = Math.sin(getPosition().r) * a;
        
        // Aggiungi l'accelerazione alla velocità corrente
        getSpeed().x += dx;
        getSpeed().y += dy;
    }
    
}
