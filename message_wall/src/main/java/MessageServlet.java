//import com.fasterxml.jackson.databind.ObjectMapper;
//
//import javax.servlet.ServletException;
//import javax.servlet.annotation.WebServlet;
//import javax.servlet.http.HttpServlet;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import java.io.IOException;
//import java.util.ArrayList;
//import java.util.List;
//
///**
// * Created with IntelliJ IDEA.
// * Description:
// * User: JIE
// * Date: 2022-10-24
// * Time: 16:20
// */
//@WebServlet("/message")
//public class MessageServlet extends HttpServlet {
//
//    private ObjectMapper objectMapper = new ObjectMapper();
//
//    // 构造一个messagelist用来存放message对象
//    private List<Message> messageList = new ArrayList<>();
//
//    // 负责让客户端提交数据给服务器
//    @Override
//    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        // 解析json数据
//        Message message = objectMapper.readValue(req.getInputStream(), Message.class);
//        // 保存解析对象
//        messageList.add(message);
//        // 在控制台打印一下解析的message数据
//        System.out.println("message" + message);
//
//
//        // 返回保存成功的响应
//        resp.setContentType("application/json; charset=utf8");
//        resp.getWriter().write("{\"ok\" : 1}");
//
//    }
//
//    // 负责让客户端从服务器拿到数据
//    @Override
//    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        // 由于约定的请求中，没有参数，不需要进行任何解析req的操作
//        resp.setContentType("application/json; charset=utf8");
//        // 把对象转换为 json格式的字符串，此处的messagelist是一个List,直接就被转换为 json数组了
//        String respString = objectMapper.writeValueAsString(messageList);
//        resp.getWriter().write(respString);
//    }
//}
