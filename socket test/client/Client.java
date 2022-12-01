package client;

import java.io.DataOutput;
import java.io.DataOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Scanner;

import jeu.Jeu;

public class Client {
    Jeu je;
    public static void main(String[] args) {
        try {
            Socket s = new Socket("localhost",1111);

            ObjectOutputStream out = new ObjectOutputStream(s.getOutputStream());
            ObjectInputStream in = new ObjectInputStream(s.getInputStream());

            Jeu j = new Jeu();
            j.setNom("nom");
            out.writeObject(j);
            out.flush();

            Jeu je = (Jeu) in.readObject();
            System.out.println(je.getNom());

            s.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            //System.out.println(e.getLocalizedMessage());
        }
    }

    public void envoyer(Socket s) throws Exception{
        ObjectOutputStream out = new ObjectOutputStream(s.getOutputStream());
        Jeu j = new Jeu();
        j.setNom("test");

        out.writeObject(j);
        out.flush();
    }

    public Jeu recevoir (Socket s) throws Exception {
        ObjectInputStream in = new ObjectInputStream(s.getInputStream());
        Jeu j =(Jeu) in.readObject();
        
        return j;
    }
}