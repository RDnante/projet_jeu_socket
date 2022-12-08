package jeu;

import jeu.Joueur;

public class Table {
    Integer[][] place;
    Joueur j1;
    Joueur j2;
    Integer encours;
    Integer tour;

    public Table() {
    }
    public Table(Integer[][] place, Joueur j1, Joueur j2) {
        this.setJ1(j1);
        this.setJ2(j2);
        this.setPlace(place);

        this.setEncours(0);
    }
    
    public Integer[][] getPlace() {
        return place;
    }
    public void setPlace(Integer[][] place) {
        this.place = place;
    }
    public Joueur getJ1() {
        return j1;
    }
    public void setJ1(Joueur j1) {
        this.j1 = j1;
    }
    public Joueur getJ2() {
        return j2;
    }
    public void setJ2(Joueur j2) {
        this.j2 = j2;
    }

    public void afficher() {
        Integer[][] pions = this.getPlace();
        for (int i = 0; i < pions.length; i++) {
            for (int j = 0; j < pions[i].length; j++) {
                System.out.print(pions[i][j]+"\t");
                if (j == pions[i].length -1) {
                    System.out.println();
                    System.out.println();
                }
            }
        }
    }
    public Integer getTour() {
        return tour;
    }
    public void setTour(Integer tour) {
        this.tour = tour;
    }
    public Integer getEncours() {
        return encours;
    }
    public void setEncours(Integer encours) {
        this.encours = encours;
    }
}