import javax.swing.JPanel;
import java.awt.*;

public class GameStart extends JPanel implements Runnable {

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

    }

    public void paintComponent(Graphics g){
        super.paintComponent(g);
        g.setColor(Color.BLACK);
        g.fillRect(10, 10, 100, 100);

    }

    private void dorme(){
        try {
            Thread.sleep(1000/60);

        } catch (Exception e){
            System.out.println(" Error em Sleep " + e);
        }
    }
}
