import javax.swing.JFrame;

public class AsteroidApp {

    public static void main(String[] args) {
        System.out.println("Asteroid Application Started");
        
        JFrame frame = new JFrame("Asteroid App");
        SpaceView spaceView = new SpaceView();
        
        frame.add(spaceView);
        frame.setSize(800, 600);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}