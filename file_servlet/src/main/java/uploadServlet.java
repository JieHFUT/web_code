import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import java.io.IOException;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: JIE
 * Date: 2022-10-26
 * Time: 19:29
 */
@MultipartConfig
@WebServlet("/upload")
public class uploadServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 就可以通过 Part 来获取文件
        Part part = req.getPart("MyFile");

        // 获取到文件的真实名字
        System.out.println(part.getName());
        System.out.println(part.getSubmittedFileName());
        // 获取到文件的大小
        System.out.println(part.getSize());
        // 获取到文件的类型
        System.out.println(part.getContentType());
        // 获取到文件的写入服务器的磁盘
        part.write("f:/result.jpg");

        resp.getWriter().write("upload ok");
    }
}
