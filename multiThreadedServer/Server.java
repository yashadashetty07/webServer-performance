package multiThreadedServer;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.function.Consumer;

public class Server {

    public static void main(String[] args) throws IOException {
        int port = 8010;
        Server server = new Server();
        ServerSocket serverSocket = new ServerSocket(port);

        try {
            
            serverSocket.setSoTimeout(10000);
            System.out.println("Server is listening on port : " + port);
            while (true) {
                Socket acceptedSocket = serverSocket.accept();
                Thread thread = new Thread(() -> server.getConsumer().accept(acceptedSocket));
                thread.start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        serverSocket.close();
        System.out.println("Server stopped.");
    }

    public Consumer<Socket> getConsumer() {

        return (clientSocket) -> {
            try {
                PrintWriter toClient = new PrintWriter(clientSocket.getOutputStream(),true);
                toClient.println("Hello from Server");
                toClient.close();
                clientSocket.close();
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        };

    };
}
