import com.fasterxml.jackson.databind.ObjectMapper;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: JIE
 * Date: 2022-10-24
 * Time: 22:30
 */

@WebServlet("/message")
public class SQLMessageServlet extends HttpServlet {

    private ObjectMapper objectMapper = new ObjectMapper();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 1、把body里面的数据解析出来
        Message message = objectMapper.readValue(req.getInputStream(), Message.class);
        // 2、把这个对象保存起来
        try {
            save(message);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        // 3、给客户端返回ok
        resp.setContentType("application/json; charset=utf8");
        resp.getWriter().write("(\"ok\"; 1)");
    }

    // 客户端从当前服务器拿到数据
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("application/json; charset=utf8");

        List<Message> messageList = null;
        try {
            messageList = load();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        String respString = objectMapper.writeValueAsString(messageList);
        resp.getWriter().write(respString);
    }


    private Connection connection = null;
    private PreparedStatement statement = null;

   // 把客户端传过来的数据存进数据库中
    private void save(Message message) throws SQLException {
        connection = DBUtil.getConnection();

        String sql = "insert into message values(?, ?, ?)";
        statement = connection.prepareStatement(sql);

        statement.setString(1, message.from);
        statement.setString(2, message.to);
        statement.setString(3, message.message);


        int req = statement.executeUpdate();
        if (req != 1) {
            System.out.println("插入失败！");
        }else{
            System.out.println("插入成功！");
        }
        DBUtil.close(connection, statement, null);
    }

    // 将数据从服务器中拿出来
    private List<Message> load() throws SQLException {
        ResultSet resultSet = null;
        List<Message> messageList = new ArrayList<>();
        // 建立连接
        connection = DBUtil.getConnection();

        // 构造sql语句
        String sql = "select * from message";
        statement = connection.prepareStatement(sql);

        // 执行sql
        resultSet = statement.executeQuery();

        // 遍历结果集
        while (resultSet.next()) {
            Message message = new Message();
            message.from = resultSet.getString("from");
            message.to = resultSet.getString("to");
            message.message = resultSet.getString("message");
            messageList.add(message);
        }
        // 释放资源
        DBUtil.close(connection, statement, resultSet);

        return messageList;

    }











}
