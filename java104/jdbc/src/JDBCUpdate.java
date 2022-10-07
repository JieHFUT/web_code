import com.mysql.jdbc.jdbc2.optional.MysqlDataSource;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class JDBCUpdate {
    public static void main(String[] args) throws SQLException {
        // 实现数据库的修改操作. 和插入非常相似.
        // 只是这里构造的 SQL 是 update 语句.

        // 1. 构造数据源
        DataSource dataSource = new MysqlDataSource();
        ((MysqlDataSource)dataSource).setUrl("jdbc:mysql://127.0.0.1:3306/java104?characterEncoding=utf8&useSSL=false");
        ((MysqlDataSource)dataSource).setUser("root");
        ((MysqlDataSource)dataSource).setPassword("2222");

        // 2. 和数据库建立连接
        Connection connection = dataSource.getConnection();

        // 3. 用户输入, 要修改的 id 和 修改后的名字
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入你要修改的同学学号: ");
        int id = scanner.nextInt();
        System.out.println("请输入你要把该同学的姓名改成什么: ");
        // next 读到空白符(空格, 制表符, 翻页符, 换行符, 回车符, 垂直制表符.....)
        // nextLine 读到换行符
        String name = scanner.next();

        // 4. 构造 SQL 语句
        String sql = "update student set name = ? where id = ?";
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setString(1, name);
        statement.setInt(2, id);
        System.out.println(statement);

        // 5. 执行 SQL
        int n = statement.executeUpdate();
        System.out.println("n = " + n);

        // 6. 关闭连接, 释放资源
        statement.close();
        connection.close();
    }
}
