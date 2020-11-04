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

    // Pulo

    private BufferedImage princesePulo[];
    private int puloAtual;
    private int altutaPulo;
    private boolean pulo;

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
        runATual = 0;
        try {
            for (int i = 0; i < 20; i++) {
                String run = "src/Sprites/Run (" + (i + 1) + ").png";
                princesaRun[i] = ImageIO.read(new File(run));
                System.out.println("Imagens " + run + "Carregadas");
            }

        } catch (Exception e) {
            System.out.println(e + "Error");
        }

        // Pulo
        princesePulo = new BufferedImage[30];
        puloAtual = 0;
        pulo = false;
        altutaPulo = 5;

        try{
            for(int i = 0; i < 30; i++){
                String pulo = "src/Sprites/Jump (" + (i + 1) + ").png";
                princesePulo[i] = ImageIO.read(new File(pulo));
                System.out.println("Imagens " + pulo + "Carregadas");
            }

        } catch (Exception e){
            System.out.println("Imagens " + pulo + "Carregadas");
        }


    }

    public void pintar(Graphics g) {

        //System.out.println("Direcao " + direcao);
        //System.out.println("ultimaDirecao " + ultimarDirecao);

        if(ultimarDirecao == 1){
            if(pulo){
                g.drawImage(princesePulo[puloAtual], posX, posY, posX + largura, posY + altura, 0, 0,
                        princesePulo[puloAtual].getWidth(),
                        princesePulo[puloAtual].getHeight(), null );
            } else {
                if(direcao == 1){
                    //System.out.println("RUN >>>>>>>>");
                    g.drawImage(princesaRun[runATual], posX, posY, posX + largura, posY + altura, 0, 0,
                            princesaRun[runATual].getWidth(), princesaRun[runATual].getHeight(), null );
                } else {
                    //System.out.println("IDLE >>>>>>>>");
                    g.drawImage(princesaIdle[idleAtual], posX, posY, posX + largura, posY + altura, 0, 0,
                            princesaIdle[idleAtual].getWidth(), princesaIdle[idleAtual].getHeight(), null );
                }
            }
        }

        if(ultimarDirecao == -1){
            if(pulo){
                g.drawImage(princesePulo[puloAtual], posX, posY, posX + largura, posY + altura,
                        princesePulo[puloAtual].getWidth(), 0, 0,
                        princesePulo[puloAtual].getHeight(), null );
            } else {
                if(direcao == -1){
                    System.out.println("RUN <<<<<<<<<");
                    g.drawImage(princesaRun[runATual], posX, posY, posX + largura, posY + altura,
                            princesaRun[runATual].getWidth(), 0, 0, princesaRun[runATual].getHeight(), null );
                } else {
                    //System.out.println("IDLE <<<<<<<<");
                    g.drawImage(princesaIdle[idleAtual], posX, posY, posX + largura, posY + altura,
                            princesaIdle[idleAtual].getWidth(), 0, 0, princesaIdle[idleAtual].getHeight(), null );
                }
            }
        }


    }

    public void update() {

        timer++;
        if(pulo){
            if(timer >= 2){
                puloAtual++;
                if(puloAtual  >= 30){
                    puloAtual=0;
                    pulo = false;
                }
                if(puloAtual < 15){
                    posY-=altutaPulo;
                } else {
                    posY +=altutaPulo;
                }
                System.out.println(puloAtual);
                // timer = 0;
            }


        } else if(!pulo) {
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

    public void iniciaPulo() {
        if(pulo == false){
            pulo = true;
            timer = 0;
            puloAtual = 0;
        }

    }
}
