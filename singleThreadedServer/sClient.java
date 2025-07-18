import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.Socket;

public class sClient {
   public void run() throws Exception {
       int port = 8010;
       InetAddress address = InetAddress.getByName("localhost");
       Socket socket = new Socket(address,port);
       PrintWriter toSocket = new PrintWriter(socket.getOutputStream());
       BufferedReader fromSocket = new BufferedReader(new InputStreamReader(socket.getInputStream()));
       toSocket.println("Hello from sClient");
       String responseFromSocket = fromSocket.readLine();
       System.out.println("Response from socket is:"+responseFromSocket);
       toSocket.close();
       fromSocket.close();
       socket.close();
   }

   public static void main(String[] args) {
       try{
           sClient sClient = new sClient();
           sClient.run();
       }
       catch (Exception ex){
           ex.printStackTrace();
       }
   }
}
