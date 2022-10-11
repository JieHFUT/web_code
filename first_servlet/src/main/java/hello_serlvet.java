import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: JIE
 * Date: 2022-10-11
 * Time: 20:01
 */
@WebServlet("/hello_serlvet")
public class hello_serlvet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 把自己自动生成的调用父类的方法; 一定要删除掉,否则会有问题

        // 这个是打印在服务器的控制台上
        System.out.println("hello_serlvet");
        // 这个是打印在响应报文中,显示到页面上
        resp.getWriter().write("hello_serlvet");
    }
}
