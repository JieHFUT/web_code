package tcpnetwork;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: JIE
 * Date: 2022-09-25
 * Time: 19:21
 */
public class TcpDictSever extends TcpEchoSever{

    private Map<String, String> dict = new HashMap<>();

    public TcpDictSever(int port) throws IOException {
        super(port);
        dict.put("cat", "小猫");
        dict.put("dog", "小狗");
        dict.put("fuck", "卧槽");
    }

    @Override
    public String process(String req) {
        return dict.getOrDefault(req, "不到");
    }

    public static void main(String[] args) throws IOException {
        TcpDictSever sever = new TcpDictSever(8000);
        sever.start();
    }





}
