package centre;

import lan.Serveur;
import jeu.*;

public class Centre {
    public static void main(String[] args) {
        Joueur j1 = new Joueur("jean", 0);
        Joueur j2 = new Joueur("pascal", 1);

        Integer[][] place = new Integer[3][3];
        place[0][0] = 0;
        place[0][1] = 1;
        place[0][2] = 0;

        place[2][0] = 1;
        place[2][1] = 0;
        place[2][2] = 1;


        Table t = new Table(place, j1, j2);
        t.afficher();

        // j1.deplacer_vertical(2, 2, t, 1);
        // j2.deplacer_ogauche(1, 1, t, -1);


        // j2.deplacer_vertical(0, 0, t, -1);
        // j2.deplacer_horizontale(1, 1, t, 1);


        t.afficher();

        Serveur se = new Serveur(t);
        se.create_Server();

        // String val = se.table_to_string(t);
        // System.out.println(val);

        // se.string_table(val,t);

        System.out.println("test");
    }
}