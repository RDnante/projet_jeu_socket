package jeu;

import java.io.Serializable;
import java.util.ArrayList;

public class Jeu implements Serializable
{
    String nom;
    ArrayList<Integer> point;

    public Jeu() {}

    public Jeu(String nom, ArrayList<Integer> point) {
        this.setNom(nom);
        this.setPoint(point);
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public ArrayList<Integer> getPoint() {
        return point;
    }

    public void setPoint(ArrayList<Integer> point) {
        this.point = point;
    }

}