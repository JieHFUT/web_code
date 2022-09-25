package udpnetwork;

import java.io.IOException;
import java.net.*;
import java.util.Scanner;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: JIE
 * Date: 2022-09-23
 * Time: 13:23
 */
public class UdpEchoClient {

    private DatagramSocket socket = null;

    public UdpEchoClient() throws SocketException {
        socket = new DatagramSocket();
    }


    public void start() throws IOException {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            // 1. 让客户端从控制台读取一个请求数据
            System.out.println("> ");
            String request = scanner.next();
            // 2. 将请求数据的字符串发送给服务器，构造 DatagramPqcket
            //    DatagramPacket 要包含传输的数据，还要包含将数据发送到哪里
            DatagramPacket requestPacket = new DatagramPacket(request.getBytes(), request.getBytes().length,
                    InetAddress.getByName("127.0.0.1"), 8000);
            // 3. 将数据报发送给服务器
            socket.send(requestPacket);
            // 4. 从服务器读取响应数据
            DatagramPacket reponsePacket = new DatagramPacket(new byte[4096], 4096);
            socket.receive(reponsePacket);
            // 5. 把响应数据获取出来,然后转换为字符串
            String response = new String(reponsePacket.getData(), 0, reponsePacket.getLength());

            System.out.printf("req: %s; resp: %s\n", request, response);
        }
    }

    public static void main(String[] args) throws IOException {
        UdpEchoClient client = new UdpEchoClient();
        client.start();
    }

}
