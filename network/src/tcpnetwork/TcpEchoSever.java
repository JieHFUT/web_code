package tcpnetwork;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: JIE
 * Date: 2022-09-25
 * Time: 0:00
 */
public class TcpEchoSever {

    private ServerSocket serverSocket = null;

    public TcpEchoSever(int port) throws IOException {
        serverSocket = new ServerSocket(port);
    }

    public void start() throws IOException {
        System.out.println("服务器启动");
        ExecutorService service = Executors.newCachedThreadPool();

        while (true){
            // 当接收不到对象的时候，就一直阻塞等待
            Socket clientSocket = serverSocket.accept();


            // 接收到了对象以后就把对象传送给处理连接的方法
            // processConnection(clientSocket);

            // 2. Thread
            /*Thread thread = new Thread(()->{
                try {
                    processConnection(clientSocket);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            });
            thread.start();*/


            // 3. 使用线程池
            service.submit(new Runnable() {
                @Override
                public void run() {
                    try {
                        processConnection(clientSocket);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            });


            //4. 一个线程对应多个客户端: IO多路复用,一个线程处理多个socket



        }
    }



    private void processConnection(Socket clientSocket) throws IOException {
        System.out.printf("[%s : %d] 建立连接！\n", clientSocket.getInetAddress().toString(),
                clientSocket.getPort());
        try (InputStream inputStream = clientSocket.getInputStream();
             OutputStream outputStream = clientSocket.getOutputStream()) {

            Scanner scanner = new Scanner(inputStream);
            PrintWriter printWriter = new PrintWriter(outputStream);

            // 这里是长连接的写法，需要通过 循环 来获取多次交互情况
            while (true){
                if (!scanner.hasNext()){
                    // 连接断开， 当客户端断开连接的时候，此时 hasnext 就会返回 false
                    System.out.printf("[%s : %d] 断开连接\n", clientSocket.getInetAddress(),
                            clientSocket.getPort());
                    break;
                }
                // 1. 读取请求并且解析
                String request = scanner.next();
                // 2. 根据请求计算响应
                String response = process(request);
                // 3. 将响应写回给客户端
                printWriter.println(response);
                printWriter.flush();

                System.out.printf("[%s : %d] request:%s; response:%s\n", clientSocket.getInetAddress(),
                        clientSocket.getPort(), request, response);
            }
        } finally {
            clientSocket.close();
        }

    }

    public String process(String request) {
        return request;
    }


    public static void main(String[] args) throws IOException {
        TcpEchoSever sever = new TcpEchoSever(8000);
        sever.start();
    }


}
