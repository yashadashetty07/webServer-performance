import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;


public class sServer {

   public void run() throws IOException {
       int port =8010;
       ServerSocket socket = new ServerSocket(port);
       socket.setSoTimeout(10000);
       while (true) {
           try {
               System.out.println("Server is listening on port" + port);
               Socket acceptedConnections = socket.accept();
               System.out.println("Accepted connection from client:"+acceptedConnections.getRemoteSocketAddress());
               PrintWriter toClient = new PrintWriter(acceptedConnections.getOutputStream());
               BufferedReader fromClient = new BufferedReader(new InputStreamReader(acceptedConnections.getInputStream()));
                toClient.println("Hello from server");
                toClient.close();
                fromClient.close();
                acceptedConnections.close();
           }
           catch (IOException ex){
               ex.printStackTrace();
           }
       }
   }

   public static void main(String[] args) {
       sServer sServer = new sServer();
       try {
           sServer.run();
       }
       catch (Exception ex){
           ex.printStackTrace();
       }
   }
}
