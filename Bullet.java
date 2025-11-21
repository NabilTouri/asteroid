public class Bullet extends BaseSpaceObject {

    
    public Bullet(BattleField universe) {
        super(universe);
        // Customize the shape for the bullet
        this.shape = new java.awt.geom.Ellipse2D.Double(-5, -5, 10, 10);
    }
    


}
