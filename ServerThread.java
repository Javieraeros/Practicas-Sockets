import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Date;

public class ServerThread extends Thread {
    private Socket socket = null;
    private int peticiones;

    public ServerThread(Socket socket,int peticiones) {
        super("KKMultiServerThread");
        this.socket = socket;
        this.peticiones=peticiones;
    }

    public void run() {
        try {
            PrintWriter out =
                    new PrintWriter(socket.getOutputStream(), true);
            out.println(new Date().toString());
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            System.out.println("Total: " + peticiones + " peticiones");
            try {
                socket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
