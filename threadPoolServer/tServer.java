package threadPoolServer;

import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class tServer {
    private final ExecutorService threadPool;

    public tServer(int poolSize) {
        this.threadPool = Executors.newFixedThreadPool(poolSize);
    }

    public void handleClient(Socket clientSocket) {
        try {
            PrintWriter toSocket = new PrintWriter(clientSocket.getOutputStream(), true);
          toSocket.println("Hello from server"); 
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        int port = 8010;
        int poolSize = 100;

        tServer server = new tServer(poolSize);
        try {
            ServerSocket serverSocket = new ServerSocket(port);
            serverSocket.setSoTimeout(600000);
            System.out.println("Server started on port: " + port);
            while (true) {
                Socket clientSocket = serverSocket.accept();
                server.threadPool.execute(() -> server.handleClient(clientSocket));
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            server.threadPool.shutdown();
        }

    }
}
