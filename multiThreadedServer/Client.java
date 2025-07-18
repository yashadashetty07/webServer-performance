package multiThreadedServer;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.Socket;

public class Client {
    public static void main(String[] args) {
        Client client = new Client();
        for (int i = 0; i < 100; i++) {
            int clientId = i; // each thread gets a unique ID
            Thread thread = new Thread(client.getRunnable(clientId));
            thread.setName("Client-Thread-" + clientId);
            thread.start();
        }
    }

    public Runnable getRunnable(int clientId) {
        return () -> {
            int port = 8010;
            try {
                InetAddress address = InetAddress.getByName("localhost");
                Socket socket = new Socket(address, port);

                PrintWriter toSocket = new PrintWriter(socket.getOutputStream(), true); // auto-flush
                BufferedReader fromSocket = new BufferedReader(new InputStreamReader(socket.getInputStream()));

                toSocket.println("Hello from Client " + clientId);
                String responseFromSocket = fromSocket.readLine();

                System.out.println("Client " + clientId + " received: " + responseFromSocket);

                toSocket.close();
                fromSocket.close();
                socket.close();
            } catch (Exception e) {
                System.err.println("Client " + clientId + " error: " + e.getMessage());
            }
        };
    }
}
