package projserver;

import java.net.*; 
import java.util.*;
import java.io.*;

public class ProjServer {

    public static void main(String[] args) throws IOException {
        int port = 8000;
        ServerSocket ss = new ServerSocket(port);
    
        while (true) {
            Socket s = ss.accept(); 
            InputStream is = s.getInputStream();
            DataInputStream dis = new DataInputStream(is);
            String message = dis.readUTF();
            System.out.println("Received:" + message);
      
            try {
                Socket web = new Socket("localhost", 8001);
                OutputStream os = web.getOutputStream();
                DataOutputStream dos = new DataOutputStream(os);
                dos.writeUTF(message);
                web.close();
            }
            catch(IOException e) { }
            System.out.println("Message sent.");
        }
    }
        
}
   