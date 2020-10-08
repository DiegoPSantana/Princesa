import javax.swing.*;

public class Janela {

    public static void main(String [] args){

        JFrame janela = new JFrame("Princesa");
        janela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        janela.setSize(1280, 720);
        janela.setResizable(false);
        janela.setLocationRelativeTo(null);

        janela.setVisible(true);

    }

}
