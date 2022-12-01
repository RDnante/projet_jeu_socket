package server;

import java.io.DataInputStream;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;
import java.io.OutputStreamWriter;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

import jeu.Jeu;

public class Server {
    public static void main(String[] args) {
        System.out.println("serveur");

        try {
            ServerSocket ss = new ServerSocket(1111);
            while(true) {
                Socket s = ss.accept();
                ObjectInputStream in = new ObjectInputStream(s.getInputStream());

                ObjectOutputStream out = new ObjectOutputStream(s.getOutputStream());
                ArrayList<Integer> points = new ArrayList<Integer>();

                Jeu je = (Jeu) in.readObject();
                System.out.println(je.getNom());

                out.writeObject(je);
                out.flush();
            }

            // s.close();
            // in.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

}