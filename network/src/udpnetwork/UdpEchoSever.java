package udpnetwork;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: JIE
 * Date: 2022-09-23
 * Time: 10:14
 */
public class UdpEchoSever {

    // 要想创建 UDP服务器， 首先要打开一个 socket 文件
    private DatagramSocket socket = null;

    public UdpEchoSever(int port) throws SocketException {
        socket = new DatagramSocket(port);
    }

    public String process(String request){
        return request;
    }

    // 启动服务器
    public void start() throws IOException {
        System.out.println("服务器启动！");
        while (true){
            //1. 读取客户端发来的请求
            DatagramPacket requestPacket = new DatagramPacket(new byte[4096], 4096);
            socket.receive(requestPacket);
            //2. 对请求进行解析， 把 DatagramPacket 转换为一个String
            String request = new String(requestPacket.getData(), 0, requestPacket.getLength());
            //3. 根据请求处理响应
            String response = process(request);
            //4. 将响应构造为 DatagramPacket 对象
            //   要搞清楚这个响应要发给谁
            DatagramPacket responsePacket = new DatagramPacket(response.getBytes(), response.getBytes().length,
                    requestPacket.getSocketAddress());
            //5. 将这个 DatagramPacket 对象返回给客户端
            socket.send(responsePacket);
            System.out.printf("[%s : %d] req=%s; resp=%s\n", requestPacket.getAddress().toString(), requestPacket.getPort(),
                    request, response);

        }
    }


    public static void main(String[] args) throws IOException {

        UdpEchoSever sever = new UdpEchoSever(8000);
        sever.start();

    }

}
