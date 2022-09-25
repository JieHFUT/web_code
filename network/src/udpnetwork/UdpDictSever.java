package udpnetwork;

import java.io.IOException;
import java.net.SocketException;
import java.util.HashMap;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: JIE
 * Date: 2022-09-23
 * Time: 15:12
 */
public class UdpDictSever extends UdpEchoSever{

    private Map<String, String> dict = new HashMap<>();

    public UdpDictSever(int port) throws SocketException {
        super(port);

        dict.put("cat", "小猫");
        dict.put("dog", "小狗");
        dict.put("fuck", "卧槽");
    }

    @Override
    public String process(String request) {
        return dict.getOrDefault(request, "I do not konw the word ");
    }

    public static void main(String[] args) throws IOException {
        UdpDictSever sever = new UdpDictSever(8000);
        sever.start();
    }


}
