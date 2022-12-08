package aff;

import javax.swing.JFrame;
import javax.swing.JPanel;

import aff.Affichage;

public class Fenetre extends JFrame {

    public Fenetre(Affichage aff) {
        this.setContentPane(aff);
        this.propconteneur();
    }

    public void propconteneur() {
        this.setTitle("Client 2");
        this.setSize(900,1050);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);
        this.setVisible(true);
    }
}