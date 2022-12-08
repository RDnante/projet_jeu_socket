package jeu;

public class Joueur {
    String nom;
    Integer pion;
    Integer selx;
    Integer sely;
    Boolean aselect;

    public Joueur() {
    }

    public Joueur(String nom, Integer pion) {
        this.setNom(nom);
        this.setPion(pion);
        this.setAselect(false);
    }

    public String getNom() {
        return nom;
    }
    public void setNom(String nom) {
        this.nom = nom;
    }
    public Integer getPion() {
        return pion;
    }
    public void setPion(Integer pion) {
        this.pion = pion;
    }

    public void select_pion(int x, int y, Table t) {
        Integer[][] place = t.getPlace();
        if (place[x][y].equals(this.getPion())) {
            this.setSelx(x);
            this.setSely(y);
            this.setAselect(true);
        }
    }

    // public void select_pion(int x, int y, Table t) {
    //     Integer[][] place = t.getPlace();
    //     if (place[x][y].equals(this.getPion())) {
    //         this.setSelx(x);
    //         this.setSely(y);
    //         this.setAselect(true);
    //     }
    // }

    public String deplacer_pion(int x, int y, Table t) {
        Integer[][] place = t.getPlace();
        String valiny = null;
        if (this.isAselect().equals(true)) {
            int diffx = Math.abs(x - this.getSelx());
            int diffy = Math.abs(y - this.getSely());
            int verif = this.verif_deplacement(x, y);
            if (diffx <=1 && diffy <= 1 && place[x][y] == null && verif == 1) {
                valiny = this.getSelx()+"::"+this.getSely()+"/"+x+"::"+y+"/"+this.getPion()+"/"+t.getTour();
                this.setAselect(false);
                this.setSelx(null);
                this.setSely(null);
            }
        }
        return valiny;
    }

    // public void deplacer_pion(int x, int y, Table t) {
    //     Integer[][] place = t.getPlace();
    //     System.out.println("fadfadf");
    //     if (this.isAselect().equals(true)) {
    //         System.out.println("mandalo");
    //         int diffx = Math.abs(x - this.getSelx());
    //         int diffy = Math.abs(y - this.getSely());
    //         int verif = this.verif_deplacement(x, y);
    //         if (diffx <=1 && diffy <= 1 && place[x][y] == null && verif == 1) {
    //             place[x][y] = this.getPion();
    //             place[this.getSelx()][this.getSely()] = null;
    //             this.setAselect(false);
    //             this.setSelx(null);
    //             this.setSely(null);
    //             System.out.println("deplacer");
    //         }
    //     }
    // }

    public int verif_deplacement(int x, int y) {
        int[] dx = {0,1,1,2};
        int[] dy = {1,0,2,1};
        int val = 0;

        for (int i = 0; i < 4; i++) {
            if (this.getSelx() == dx[i] && this.getSely() == dy[i]){
                if (this.getSelx() != x && this.getSely() != y) {
                    return 0;
                }
                System.out.println("cas"+dx[i]+" "+dy[i]);
            }
            else {
                val = 1;
            }
        }

        return val;
    }

    public int verif_victoire(Table t) {
        int victoire = 0;
        victoire = this.verif_victoire_hor(t);
        if (victoire == 1) return 1;
        victoire = this.verif_victoire_vert(t);
        if (victoire == 1) return 1;
        victoire = this.verif_victoire_obl(t);
        if (victoire == 1) return 1;

        return victoire;
    }

    public int verif_victoire_vert(Table t) {
        Integer[][] place = t.getPlace();
        int compteur = 0;
        for (int i = 0; i < place.length; i++) {
            for (int j = 0; j < place.length; j++) {
                if (place[i][j] != null && place[i][j].equals(this.getPion())) {   
                    compteur++;
                    //System.out.println("comt"+compteur);
                }
                if (compteur == 3) {
                    return 1;
                }
                if (j == 2) {
                    compteur = 0;
                }
                
            }
        }

        return 0;
    }

    public int verif_victoire_hor(Table t) {
        Integer[][] place = t.getPlace();
        int compteur = 0;
        for (int i = 0; i < place.length; i++) {
            for (int j = 0; j < place.length; j++) {
                if (place[j][i] != null && place[j][i].equals(this.getPion())) {   
                    compteur++;
                    //System.out.println("comt"+compteur);
                }
                if (compteur == 3) {
                    return 1;
                }
                if (j == 2) {
                    compteur = 0;
                }
                
            }
        }

        return 0;
    }

    public int verif_victoire_obl(Table t) {
        Integer[][] place = t.getPlace();
        int compteur = 0;
        for (int i = 0; i < place.length; i++) {
                if (place[i][i] != null && place[i][i].equals(this.getPion()) == true) {   
                    compteur++;
                    //System.out.println("comt"+compteur);
                }
                if (compteur == 3) {
                    return 1;
                }
                if (i == 2) {
                    compteur = 0;
                }
        }

        int y = 2;
        for (int i = 0; i < place.length; i++) {
            if (place[i][y] != null && place[i][y].equals(this.getPion() ) == true) {   
                compteur++;
                //System.out.println("comt"+compteur);
            }
            if (compteur == 3) {
                return 1;
            }
            if (i == 2) {
                compteur = 0;
            }
            y--;
        }

        return 0;
    }

    public Integer getSelx() {
        return selx;
    }

    public void setSelx(Integer selx) {
        this.selx = selx;
    }

    public Integer getSely() {
        return sely;
    }

    public void setSely(Integer sely) {
        this.sely = sely;
    }

    public Boolean isAselect() {
        return aselect;
    }

    public void setAselect(Boolean aselect) {
        this.aselect = aselect;
    }
}