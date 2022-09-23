package network;

import java.io.IOException;
import java.net.ServerSocket;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: JIE
 * Date: 2022-09-23
 * Time: 10:10
 */
public class TcpEchoServer {

    private ServerSocket serverSocket = null;

    public TcpEchoServer(int port) throws IOException {
        serverSocket = new ServerSocket(port);
    }


    public void start() {
        System.out.println("sever start");
        while (true){

        }
    }








}
