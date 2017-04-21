import java.io.IOException;
import java.net.ServerSocket;

/**
 * A TCP server that runs on port 9090.  When a client connects, it
 * sends the client the current date and time, then closes the
 * connection with that client.  Arguably just about the simplest
 * server you can write.
 */
public class DateServer {

    /**
     * Runs the server.
     */
    public static void main(String[] args) throws IOException {
        boolean finish;
        try (ServerSocket listener = new ServerSocket(9090)) {
            int peticiones = 0;
            while (true) {
		peticiones++;
                new ServerThread(listener.accept(),peticiones).start();
            }
        }
    }

}
