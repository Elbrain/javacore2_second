package network;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketTimeoutException;

public class ServerSocketThread extends Thread {
    private final int port;
    private int timeOut;
    ServerSocketThreadListener listener;

    public ServerSocketThread(ServerSocketThreadListener listener, String name, int port, int timeOut) {
        super(name);
        this.port = port;
        this.timeOut = timeOut;
        this.listener = listener;
        start();
    }

    @Override
    public void run() {
        //System.out.println("Server socket thread started");
        listener.onServerStart(this);
        try (ServerSocket serverSocket = new ServerSocket(port)) {
            serverSocket.setSoTimeout(timeOut);
            //System.out.println("Server connection created");
            listener.onServerSocketCreated(this, serverSocket);
            while (!interrupted()) {
                Socket socket = null;
                try {
                    socket = serverSocket.accept();
                    //System.out.println("Client accepted");
                    listener.onSocketAccepted(this, serverSocket, socket);
                } catch (SocketTimeoutException e) {
                    listener.onServerTimeout(this, serverSocket);
                }
            }
        } catch (IOException e){
            listener.onServerException(this, e);
        }
        finally {
            //System.out.println("Server stopped");
            listener.onServerStop(this);
        }
    }
}
