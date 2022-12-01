package td;

import j.Jeu;

public class Thread1 implements Runnable {

    public Thread1 () {}

    @Override
    public void run() {

        try {
            Jeu jeu = new Jeu();
            jeu.setNom("jeu de point");

            for (int i = 0; i < 10; i++) {
                Thread.sleep(5000);
                jeu.setPoint(i);
                System.out.println(jeu.getNom());
                System.out.println("point actuelle ="+i);
            }
        } catch (Exception e) {
            // TODO: handle exception
        }
        
    }

}