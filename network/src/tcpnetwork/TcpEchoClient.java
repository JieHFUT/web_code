package tcpnetwork;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: JIE
 * Date: 2022-09-25
 * Time: 0:01
 */
public class TcpEchoClient {

    private Socket socket = null;

    public TcpEchoClient() throws IOException {
        socket = new Socket("127.0.0.1", 8000);
    }

    public void start() throws IOException {
        // 由于我们实现的是长连接,所以我们会处理N个请求和响应
        Scanner scanner = new Scanner(System.in);

        try (InputStream inputStream = socket.getInputStream();
             OutputStream outputStream = socket.getOutputStream()){
            Scanner scannerNet = new Scanner(inputStream);
            PrintWriter printWriter = new PrintWriter(outputStream);

            while (true) {
                // 1. 从控制台读取用户输入的信息
                System.out.println("> ");
                String request = scanner.next();
                // 2. 把请求发送给服务器
                printWriter.println(request);
                printWriter.flush();
                // 3. 从服务器读取响应
                String response = scannerNet.next();
                // 4. 把响应的结果显示在界面上
                System.out.printf("[reauest: %s; response: %s\n]", request, response);
            }
        }
    }

    public static void main(String[] args) throws IOException {
        TcpEchoClient client = new TcpEchoClient();
        client.start();
    }
}
