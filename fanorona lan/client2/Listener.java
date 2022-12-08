package aff;

import java.awt.*;
import java.awt.event.*;
import java.io.DataOutputStream;

import javax.swing.*;
import javax.swing.event.*;

import aff.Affichage;
import jeu.Joueur;
import jeu.Trait;;

public class Listener implements MouseListener {
    Affichage aff;

    public Listener(Affichage aff) {
        this.aff = aff;
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        System.out.println("X"+e.getX()/400);
        System.out.println("Y"+e.getY()/400);

        int y = e.getX()/350;
        int x = e.getY()/350;

        System.out.println("tour"+this.aff.getClient().getJeu().getTour());
    
        if (this.aff.getClient().getJeu().getTour() == 1 && this.aff.getClient().getJeu().getEncours() == 1) {
            if (this.aff.getClient().getJeu().getJ2().getPion().equals(this.aff.getClient().getJeu().getPlace()[x][y])) {
                this.aff.getClient().getJeu().getJ2().select_pion(x, y, this.aff.getClient().getJeu());
                System.out.println("selectionner");
            }

            if (this.aff.getClient().getJeu().getPlace()[x][y] == null) {
                String s = this.aff.getClient().getJeu().getJ2().deplacer_pion(x, y, this.aff.getClient().getJeu());

                try {
                    System.out.println(s);
                    DataOutputStream out = null;
                    out = new DataOutputStream(this.aff.getClient().getS().getOutputStream());
                    out.writeUTF(s);
                    out.flush();    

                } catch (Exception ex) {
                    System.out.println(ex.getMessage());
                }

                // this.aff.getTable().getJ2().verif_deplacement(x, y);
                System.out.println("deplacer");
            }
        }

        this.aff.requestFocus();
        this.aff.repaint();
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        
    }

    @Override
    public void mouseExited(MouseEvent e) {
        
    }

    @Override
    public void mousePressed(MouseEvent e) {
        
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        
    }

}