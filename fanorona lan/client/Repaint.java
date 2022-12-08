package jeu;

import java.io.DataInputStream;

import aff.Affichage;
import lan.*;

public class Repaint implements Runnable {
    Affichage aff;

    public Repaint(Affichage aff) {
        this.aff = aff;
    }

    @Override
    public void run() {
        try {
            while(true) {
                this.aff.repaint();
                if (this.aff.getClient().getJeu().getEncours().equals(0)) {
                    // this.aff.getText().setText("vita ny lalao !!!");
                }
                else {
                    if (this.aff.getClient().getJeu().getEncours().equals(1) && this.aff.getClient().getJeu().getTour().equals(0)) {
                        this.aff.getText().setText("votre tour !!!");
                    }
                    else {
                        this.aff.getText().setText("adversaire turn");
                    }
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}