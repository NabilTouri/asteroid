import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;

import javax.swing.JPanel;
import javax.swing.Timer;

public class SpaceView extends JPanel implements KeyListener {
    BattleField universe = new BattleField();

    public SpaceView() {
        this.setFocusable(true);
        this.requestFocusInWindow();

        this.addKeyListener(this);
        Timer animator = new Timer(10, e -> {
            applyControls();
            universe.stepNext();
            repaint();
        });
        animator.start();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;

        double s = Math.min(getWidth(), getHeight()) / 1000.;
        g2.translate(getWidth()/2, getHeight()/2);
        g2.scale(s, -s);

        g2.setColor(Color.black);
        g2.fillRect(-500, -500, 1000, 1000);

        g2.setColor(Color.white);
        for(SpaceObject o: universe.listSpaceObjects()) {
            g2.draw(o.getShape());
        }
    }

    private void applyControls() {
        SpaceShip s = universe.getSpaceShip();
        if(s==null)
            return;

        for(Integer keyCode: currentActiveKeys) {
            switch (keyCode) {
                case KeyEvent.VK_UP:
                    s.accelerate(0.2);
                    break;
                
                case KeyEvent.VK_DOWN:
                    s.accelerate(-0.2); 
                    break;
                
                case KeyEvent.VK_RIGHT:
                    s.turn(-0.1);
                    break;
                    
                case KeyEvent.VK_LEFT:
                    s.turn(0.1);
                    break;
                
                case KeyEvent.VK_B:
                    s.setSpeed(new SpaceCoord(0, 0, 0));
                    break;
                
                default:
                    break;
            }
        }
    }

    private ArrayList<Integer> currentActiveKeys = new ArrayList<>();
    @Override
    public void keyTyped(KeyEvent e) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void keyPressed(KeyEvent e) {
        if(!currentActiveKeys.contains(e.getKeyCode()))
            currentActiveKeys.add(e.getKeyCode());
        
    }

    @Override
    public void keyReleased(KeyEvent e) {
        currentActiveKeys.remove((Integer)e.getKeyCode());
        
    }
    
}
