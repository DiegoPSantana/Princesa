import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;

public class Princesa {

    int posX, posY, velocida, largura, altura;
    int direcao, ultimarDirecao;

    int timer;

    private BufferedImage princesaIdle[];
    private int idleAtual;

    // Run
    private BufferedImage princesaRun[];
    private int runATual;

    public Princesa(){
        posX = 200;
        posY = 350;
        velocida = 5;
        largura = 200;
        altura = 200;
        ultimarDirecao = 1;



        princesaIdle = new BufferedImage[20];
        idleAtual = 0;

        try {
            for (int i = 0; i < 20; i++) {
                String idle = "src/Sprites/Idle (" + (i + 1) + ").png";
                princesaIdle[i] = ImageIO.read(new File(idle));
                System.out.println("Imagens " + idle + "Carregadas");
            }

        } catch (Exception e){
            System.out.println("Imagens idle Não Carregadas");
        }
        // Run
        princesaRun = new BufferedImage[20];
        runATual = 0;a
        try {
            for (int i = 0; i < 20; i++) {
                String run = "src/Sprites/Run (" + (i + 1) + ").png";
                princesaRun[i] = ImageIO.read(new File(run));
                System.out.println("Imagens " + run + "Carregadas");
            }

        } catch (Exception e) {
            System.out.println(e + "Error");
        }


    }

    public void pintar(Graphics g) {

        //System.out.println("Direcao " + direcao);
        //System.out.println("ultimaDirecao " + ultimarDirecao);

        if(ultimarDirecao == 1){
            if(direcao == 1){
                System.out.println("RUN >>>>>>>>");
                g.drawImage(princesaRun[runATual], posX, posY, posX + largura, posY + altura, 0, 0,
                        princesaRun[runATual].getWidth(), princesaRun[runATual].getHeight(), null );
            } else {
                System.out.println("IDLE >>>>>>>>");
                g.drawImage(princesaIdle[idleAtual], posX, posY, posX + largura, posY + altura, 0, 0,
                        princesaIdle[idleAtual].getWidth(), princesaIdle[idleAtual].getHeight(), null );
            }
        }

        if(ultimarDirecao == -1){
            if(direcao == -1){
                System.out.println("RUN <<<<<<<<<");
                g.drawImage(princesaRun[runATual], posX, posY, posX + largura, posY + altura,
                        princesaRun[runATual].getWidth(), 0, 0, princesaRun[runATual].getHeight(), null );
            } else {
                System.out.println("IDLE <<<<<<<<");
                g.drawImage(princesaIdle[idleAtual], posX, posY, posX + largura, posY + altura,
                        princesaIdle[idleAtual].getWidth(), 0, 0, princesaIdle[idleAtual].getHeight(), null );
            }
        }


    }

    public void update() {

        timer++;
        if (timer >= 2) {
            idleAtual++;
            if (idleAtual >= 20) {
                idleAtual = 0;
            }
            runATual++;
            if (runATual >= 20) {
                runATual = 0;

            }
            //System.out.println(runATual);
            timer = 0;
        }

        if (direcao == 1) {
            posX += velocida;
        } else if (direcao == -1) {
            posX -= velocida;
        }

    }

    public void movimento(int dir) {
        if (dir != 0) {
            direcao = dir;
            ultimarDirecao = dir;
        } else {
            direcao = dir;
        }
    }
}
