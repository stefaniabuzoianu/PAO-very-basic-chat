package projclientreader;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;
public class ProjClientReader {

    public static void main(String[] args) throws IOException {
        int port = 8000;
        ServerSocket ss = new ServerSocket(port);

        while (true) {
          Socket s = ss.accept(); 
          InputStream is = s.getInputStream();
          DataInputStream dis = new DataInputStream(is);
          String message = dis.readUTF();
          System.out.println(message);
        }
    }
 }
    
