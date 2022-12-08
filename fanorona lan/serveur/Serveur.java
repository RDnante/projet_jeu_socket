package lan;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

import jeu.Table;
import jeu.*;

public class Serveur {
    Table jeu;
    ServerSocket ss;
    ArrayList<Socket> s = new ArrayList<Socket>();

    public Serveur() {}


    public Serveur(Table jeu) {
        this.setJeu(jeu);
        this.getJeu().setTour(0);
    }

    public void create_Server() {
        try {
            this.setSs(new ServerSocket(9999));
            for (int i = 0; i < 2; i++) {
                System.out.println("miandry");
                this.getS().add(this.getSs().accept());
                System.out.println("aceepter");
            }

            this.init();
            this.mihaino();
            System.out.println("tafiditra");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public void change(String donne) throws Exception {
        String[] tab = donne.split("/");
        String[] ovaina = tab[0].split("::");
        String[] manova = tab[1].split("::");

        for (int i = 0; i < tab.length; i++) {
            System.out.println("tab"+tab[i]);
        }

        for (int i = 0; i < ovaina.length; i++) {
            System.out.println("ovaina"+ovaina[i]);
        }

        for (int i = 0; i < manova.length; i++) {
            System.out.println("manova"+manova[i]);
        }

        int selx = Integer.parseInt(ovaina[0]);
        int sely = Integer.parseInt(ovaina[1]);
        int x = Integer.parseInt(manova[0]);
        int y = Integer.parseInt(manova[1]);
        int pion = Integer.parseInt(tab[2]);
        int tour = Integer.parseInt(tab[3]);

        this.init_tour(tour, this.getJeu());
        this.getJeu().getPlace()[selx][sely] = null;
        this.getJeu().getPlace()[x][y] = pion;

        ObjectOutputStream out = null;

        String vict = verif_victoire(this.getJeu());
        String alefa = null;
        if ( vict != null) {
            alefa = this.table_to_string(this.getJeu()) + vict;
        }
        else {
            alefa = this.table_to_string(this.getJeu());
        }
        for (int i = 0; i < 2; i++) {
            out = new ObjectOutputStream(this.getS().get(i).getOutputStream());
            out.writeObject(alefa);
            out.flush();
        }
    }

    public String verif_victoire(Table t) {
        if (t.getJ1().verif_victoire(t) == 1) return "::nandresy::resy";
        if (t.getJ2().verif_victoire(t) == 1) return "::resy::nandresy";
        return null;
    }

    public void mihaino() throws Exception {
        Trait t = new Trait(this);
        Thread th = new Thread(t);
        th.start();
    }

    public void init() throws Exception {
        this.getJeu().setEncours(1);
        String donne = this.table_to_string(this.getJeu());
        ObjectOutputStream out = null;
        for (int i = 0; i < 2; i++) {
            out = new ObjectOutputStream(this.getS().get(i).getOutputStream());
            out.writeObject(donne);
            out.flush();
        }
    }

    public String table_to_string(Table t) {
        Integer[][] place = t.getPlace();
        Integer tour = t.getTour();
        Integer encours = t.getEncours();
        String valiny = new String();

        for (int i = 0; i < place.length; i++) {
            for (int j = 0; j < place[i].length; j++) {
                valiny = valiny + "::" + place[i][j];
            }
        }
        valiny = valiny + "::" + tour + "::" + encours;

        return valiny;
    }

    public void string_table(String donne, Table t) {
        Integer[][] place = t.getPlace();
        String[] val = donne.split("::");
        int init = 1;
        for (int i = 0; i < place.length; i++) {
            for (int j = 0; j < place[i].length; j++) {
                if (val[init].equals("null") == false) {
                    place[i][j] = Integer.parseInt(val[init]);
                }
                else {
                    place[i][j] = null;
                }
                init++;
            }
        }
        t.setTour(Integer.parseInt(val[val.length -2]));
        t.setPlace(place);
        t.setEncours(Integer.parseInt(val[val.length -1]));

        System.out.println("tour"+t.getTour());
        t.afficher();
    }

    public void init_tour(Integer tour,Table t) {
        if (tour == 0) {
            t.setTour(1);
        }
        if (tour == 1){
            t.setTour(0);
        }
    }

    public Table getJeu() {
        return jeu;
    }

    public void setJeu(Table jeu) {
        this.jeu = jeu;
    }


    public ServerSocket getSs() {
        return ss;
    }


    public void setSs(ServerSocket ss) {
        this.ss = ss;
    }


    public ArrayList<Socket> getS() {
        return s;
    }


    public void setS(ArrayList<Socket> s) {
        this.s = s;
    }

}