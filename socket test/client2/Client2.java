package client;

import java.io.DataOutput;
import java.io.DataOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.InetAddress;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Scanner;

import jeu.Jeu;

public class Client2 {
    public static void main(String[] args) {
        try {
            Socket s = new Socket("localhost",1111);

            ObjectOutputStream out = new ObjectOutputStream(s.getOutputStream());
            ObjectInputStream in = new ObjectInputStream(s.getInputStream());
            
            Jeu je = new Jeu();

            je.setNom("deux");
            out.writeObject(je);
            out.flush();

            Jeu j = (Jeu) in.readObject();
            System.out.println(j.getNom());

            s.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            //System.out.println(e.getLocalizedMessage());
        }
    }
}