import com.fasterxml.jackson.databind.ObjectMapper;

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
 * Date: 2022-10-23
 * Time: 22:34
 */
@WebServlet("/studentInfo")
public class StudentInfoServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html; charset=utf8");
        // 假设客户发来的请求形如：/studentInfo?studentId=104&studentId=20
        // 就可以通过 getParameter方法拿到这两个id值
        String queryString = req.getQueryString();
        System.out.println(queryString);
        String classId = req.getParameter("classId");
        String studentId = req.getParameter("studentId");
        System.out.println("classId:" + classId + " ;" + " studentId:" + studentId);
        resp.getWriter().write("classId:" + classId + " ;" + " studentId:" + studentId);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //x-www-from-urlencoded
        //this.doGet(req, resp);


        //json
        ObjectMapper objectMapper = new ObjectMapper();
        // 从请求的body中取读取请求的数据，解析
        // 使用 readValue 来把json字符串转换为Java对象
        // 第一个参数是一个String 或者是一个 InputStream
        // 第二个参数是一个转换结果对应的Java 类对象
        Student student = objectMapper.readValue(req.getInputStream(), Student.class);
        System.out.println(student.classId + "; " + student.studentId);
        resp.getWriter().write(student.classId + "; " + student.studentId);

    }
}
