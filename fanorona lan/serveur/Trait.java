package jeu;

import java.io.DataInputStream;

import lan.*;

public class Trait implements Runnable {
    Serveur s;

    public Trait(Serveur c) {
        this.s= c;
    }

    @Override
    public void run() {
        try {
            DataInputStream dis = null;

            while(true) {
                if (this.s.getJeu().getTour() == 0) {
                    dis = new DataInputStream(this.s.getS().get(0).getInputStream());
                }
                if (this.s.getJeu().getTour() == 1) {
                    dis = new DataInputStream(this.s.getS().get(1).getInputStream());
                }
        
                System.out.println(1);
                String donne = dis.readUTF();
                
                this.s.change(donne);
                    

                    
                System.out.println(3);
                System.out.println("thread serveur");

                Thread.sleep(20);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}