package aff;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.*;

import javax.swing.JLabel;
import javax.swing.JPanel;

import jeu.Joueur;
import jeu.Table;
import lan.Client;

public class Affichage extends JPanel {
    Table table;
    Client client;
    JLabel text;
    int l = 350;

    public Affichage(Client c) {
        // this.setTable(table);
        this.setClient(c);
        this.setLayout(null);
        this.propconteneur();  
        this.setFocusable(true);
        this.requestFocusInWindow();
    }

    public void propconteneur() {
        this.proptext();
        Listener li = new Listener(this);
        this.addMouseListener(li);
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        this.trait(g);
        this.pions(g);
    }

    public void pions(Graphics g) {
        Integer[][] place = this.getClient().getJeu().getPlace();
        Joueur j1 = this.getClient().getJeu().getJ1();
        Joueur j2 = this.getClient().getJeu().getJ2();

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (place[i][j] != null && place[i][j].equals(j1.getPion())==true) {
                    int y = i*l;
                    int x = j*l;
                    g.setColor(Color.blue);
                    g.fillArc(x+25, y+150, 90, 90, 0, 360);
                }
                if (place[i][j] != null && place[i][j].equals(j2.getPion())==true) {
                    int y = i*l;
                    int x = j*l;
                    g.setColor(Color.black);
                    g.fillArc(x+25, y+150, 90, 90, 0, 360);
                }
            }
        }
    }

    public void trait(Graphics g) {
        int lon = 770;
        int pos = 70;
        int posy = 125;
        g.setColor(Color.black);
        g.drawLine(pos, pos+posy, lon, lon+posy);
        g.drawLine(lon, pos+posy, pos, lon+posy);


        int x = 70;
        for (int i = 0; i < 3; i++) {
            g.drawLine(x, pos+posy, x, lon+posy);
            x += l;
        }

        int y = 70;
        for (int i = 0; i < 3; i++) {
            g.drawLine(pos, y+posy, lon, y+posy);
            y += l;
        }
    }

    public void proptext() {
        this.text = new JLabel();
        this.text.setText("action");
        this.text.setBounds(30,30,800,100);
        this.text.setFont(new Font("Serif",Font.PLAIN,30));
        this.text.setOpaque(true);
        this.text.setBackground(Color.LIGHT_GRAY);
        this.add(text);
    }

    public Table getTable() {
        return table;
    }

    public void setTable(Table table) {
        this.table = table;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public JLabel getText() {
        return text;
    }

    public void setText(JLabel text) {
        this.text = text;
    }

    public int getL() {
        return l;
    }

    public void setL(int l) {
        this.l = l;
    }

}