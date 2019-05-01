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
        System.out.println("Bienvenido a Pegasus.");
        System.out.println("Pegasus es una cyberArma diseñada para la busqueda y explotacion de vulnerabilidades, en este caso");
        System.out.println("Explotaremos la vulnerabilidad para obtener las credenciales de acceso al sistema.");
        System.out.println("NOsotros no nos hacemos responsables por el mal uso que se le de a este software.");
        try {
            while (true) {
                System.out.println("Cliene conectado ");
                System.out.println("Si desea correr comandos ya establecidos, marque 1.");
                BufferedReader stdIn = new BufferedReader(new InputStreamReader(System.in));
                String linea = stdIn.readLine();

                PrintWriter pr = new PrintWriter(s.getOutputStream());
                pr.println(linea);
                pr.flush();
                
                InputStreamReader in = new InputStreamReader(s.getInputStream());
                BufferedReader bf = new BufferedReader(in);
                String str = bf.readLine();
                if(str==null){
                    str+="";
                }

                String[] temp=str.split("\\?");
                String resp="";
               //System.out.println("El cliente dijo: ");
                for(int i=0;i<temp.length;i++){
                    System.out.println(temp[i]);
                }

                //System.out.println(str);//Clieinte dijo
            }
        } catch (IOException e) {
            System.out.println("IOException: " + e.getMessage());
        }

    }

}
