/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ser;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

/**
 *
 * @author 2098325
 */
public class Ser {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
        ServerSocket ss = new ServerSocket(4999);
        Socket s = ss.accept();
        try {
            while (true) {
                System.out.println("Cliene conectado ");

                
                
                BufferedReader stdIn = new BufferedReader(new InputStreamReader(System.in));
                String linea = stdIn.readLine();

                PrintWriter pr = new PrintWriter(s.getOutputStream());
                pr.println("que pasooo : " + linea);
                pr.flush();
                
                
                InputStreamReader in = new InputStreamReader(s.getInputStream());
                BufferedReader bf = new BufferedReader(in);
                String str = bf.readLine();
                System.out.println("Cliene dijo: " + str);


            }
        } catch (IOException e) {
            System.out.println("IOException: " + e.getMessage());
        }

    }

}
