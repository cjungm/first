import java.net.ServerSocket;
import java.net.Socket;

public class Server{
    public static void main(String[] args) {
    ServerSocket serversocket = null;
    Socket socket = null;
    try {
        System.out.println("Server Start!");
        serversocket = new ServerSocket(9500);
        socket = serversocket.accept();
        System.out.println("ok");
        Thread thread2 = new receiverthread(socket);
        thread2.start();
    } catch(Exception e) {
        //TODO: handle exception
    }finally {
        try {
            System.out.println("close");
            }catch(Exception e2) {
            }

        }

    }

    

}