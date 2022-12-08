package lan;

import java.net.Socket;
import java.util.Scanner;

import jeu.*;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

import aff.Affichage;
import aff.Fenetre;


public class Client {
    Table jeu;
    Affichage aff;
    Socket s;

    public Client() {
    }

    public Client(Table jeu) {
        this.setJeu(jeu);
    }

    public void create_Client() {
        try {
            this.setS(new Socket("localhost",9999));

            Trait tr = new Trait(this);
            Thread th = new Thread(tr);
            th.start();
            System.out.println("initialized");

            Affichage aff = new Affichage(this);
            this.setAff(aff);
            Fenetre fe = new Fenetre(aff);

            Repaint re = new Repaint(aff);
            Thread th2 = new Thread(re);
            th2.start();
            
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        
    }

    public void init(ObjectInputStream out) throws Exception {
        String place = (String) out.readObject();

        this.string_table(place, this.getJeu());
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

        if (val[val.length -1].equals("nandresy") || val[val.length -1].equals("resy")) {
            t.setEncours(0);
            if (val[val.length -2].equals("nandresy")) {
                System.out.println("resy");
                this.getAff().getText().setText("resy ianao");
            }
            else {
                this.getAff().getText().setText("nandresy ianao");
            }
        }
        else {
            t.setTour(Integer.parseInt(val[val.length -2]));
            t.setEncours(Integer.parseInt(val[val.length -1]));
        }
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
        t.setPlace(place);
        System.out.println("tour"+t.getTour());
        t.afficher();
        
    }

    public Table getJeu() {
        return jeu;
    }

    public void setJeu(Table jeu) {
        this.jeu = jeu;
    }

    public Socket getS() {
        return s;
    }

    public void setS(Socket s) {
        this.s = s;
    }

    public Affichage getAff() {
        return aff;
    }

    public void setAff(Affichage aff) {
        this.aff = aff;
    }
}