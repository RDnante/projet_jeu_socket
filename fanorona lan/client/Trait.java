package jeu;

import java.io.ObjectInput;
import java.io.ObjectInputStream;

import lan.*;

public class Trait implements Runnable {
    Client c;

    public Trait(Client c) {
        this.c= c;
    }

    @Override
    public void run() {
        try {
            ObjectInputStream in = null;
            while(true) {
                in = new ObjectInputStream(this.c.getS().getInputStream());
                System.out.println("mandalo 1");
                this.c.init(in);
                System.out.println("mandalo 2");
                this.c.getJeu().afficher();
                System.out.println("mandalo 3");
                Thread.sleep(30);
            }
        } catch (Exception e) {
            // TODO: handle exception
        }
    }
}