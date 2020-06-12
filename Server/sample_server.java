import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

public class sample_server {
    public static void main(String[] args) throws Exception {
        try (
                ServerSocket server = new ServerSocket(8000);
                Socket socket = server.accept();
                BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream(), "UTF-8"));
        ) {

            String line = in.readLine();
            StringBuilder header = new StringBuilder();

            while (line != null && !line.isEmpty()) { // 空行になるまで読み込みを続ける
                header.append(line + "\n");
                line = in.readLine();
            }
            System.out.println(header);

            InetAddress ip;
            ip = InetAddress.getLocalHost();
            System.out.println(ip);
        }
    }
}