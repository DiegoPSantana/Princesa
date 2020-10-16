import javax.swing.JPanel;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class GameStart extends JPanel implements Runnable, KeyListener {

    Princesa prin = new Princesa();

    public GameStart(){
        Thread processoGame = new Thread(this);
        processoGame.start();
    }

    @Override
    public void run() {
        while(true){
            update();
            repaint();
            dorme();
        }

    }

    public void update(){
    prin.update();
    }

    public void paintComponent(Graphics g){
        super.paintComponent(g);
        g.setColor(Color.darkGray);
        g.fillRect(0, 450, 1280, 200);
        prin.pintar(g);

    }

    private void dorme(){
        try {
            Thread.sleep(1000/60);

        } catch (Exception e){
            System.out.println(" Error em Sleep " + e);
        }
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        if(e.getKeyCode() == KeyEvent.VK_D){
            prin.movimento(1);
        } else if(e.getKeyCode() == KeyEvent.VK_A){
            prin.movimento(-1);
        }

    }

    @Override
    public void keyReleased(KeyEvent e) {
        if(e.getKeyCode() == KeyEvent.VK_D || e.getKeyCode() == KeyEvent.VK_A ){
            prin.movimento(0);
        }
    }
}
