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
@WebServlet("/hello_servlet")
public class hello_servlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 告诉浏览器按照什么编码方式
        resp.setContentType("text/html; charset=utf8");

        //resp.setContentType("text/html");
        //resp.setCharacterEncoding("utf8");

        // 把自己自动生成的调用父类的方法; 一定要删除掉,否则会有问题

        // 这个是打印在服务器的控制台上
        System.out.println("doget");
        // 这个是打印在响应报文中,显示到页面上
        resp.getWriter().write("你好！世界");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("dopost");
        resp.getWriter().write("dopost");
    }

    @Override
    protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("doput");
        resp.getWriter().write("doput");
    }


    @Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("delete");
        resp.getWriter().write("delete");
    }
}
