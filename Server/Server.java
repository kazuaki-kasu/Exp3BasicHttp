import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.InetAddress;
import java.util.Date;

public class Server{

    public static void main(String[] args) throws Exception {
        try(
                //ソケット生成
                ServerSocket server = new ServerSocket(8000);
                //クライアントからの接続を待つ
                 Socket socket = server.accept();

            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream(), "UTF-8"));
        ){

            String line = in.readLine();
            StringBuilder header = new StringBuilder();
            Integer contentLength = 0;

            header.append("Hello:BasicHTTP!\n");

            while(line!=null&&!line.isEmpty()){
                if (line.startsWith("Content-Length")) { // Content-Length を取得
                    contentLength = Integer.parseInt(line.split(":")[1].trim());
                }
                header.append(line+"\n");
                line = in.readLine();
            }

            String body = null;
            if (0 < contentLength) { // ★Content-Length 分取得
                char[] c = new char[contentLength];
                in.read(c);
                body = new String(c);
            }

            InetAddress ip;
            ip = InetAddress.getLocalHost();

            System.out.println(header);
            Date date = new Date();
            System.out.println(date.toString());

            System.out.println(ip);
        }
    }
}