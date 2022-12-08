package jeu;

import lan.Serveur;

public class Envoyer implements Runnable {
    Serveur serveur;

    public Envoyer(Serveur ser) {
        this.setServeur(ser);
    }

    @Override
    public void run() {
        // while(true) {
        //     for (int j = 0; j < array.length; j++) {
                
        //     }
        //     this.s.getOut().get(i).writeObject(this.s.getJeu().getPlace());
        //     this.s.getOut().get(i).flush();
        // }        
    }

    public Serveur getServeur() {
        return serveur;
    }

    public void setServeur(Serveur serveur) {
        this.serveur = serveur;
    }

}