import com.mysql.jdbc.jdbc2.optional.MysqlDataSource;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class JDBCInsert {
    public static void main(String[] args) throws SQLException {
        // 1. 使用 DataSource 描述 MySQL 服务器的位置.
        DataSource dataSource = new MysqlDataSource();
        ((MysqlDataSource)dataSource).setUrl("jdbc:mysql://127.0.0.1:3306/java104?characterEncoding=utf8&useSSL=false");
        ((MysqlDataSource)dataSource).setUser("root");
        ((MysqlDataSource)dataSource).setPassword("2222");

        // 2. 和数据库服务器建立连接~
        Connection connection = dataSource.getConnection();
        // System.out.println(connection);

        // 3. 构造 SQL 语句. JDBC 操作数据库, 本质仍然是通过 SQL 来描述数据库操作~~
        //    例如, 进行一个插入数据的操作.
        //    直接用 String 格式的 SQL 还不行, 还需要搭配一个 特殊的类.
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入学号: ");
        int num = scanner.nextInt();
        System.out.println("请输入姓名: ");
        String name = scanner.next();

        // 这个是不科学的写法!!
        // String sql = "insert into student values(" + num + ", '" + name + "')";

        // 这个是科学的写法:
        // 使用 ? 作为占位符. 后续使用 statement 对象针对 ? 进行替换.
        String sql = "insert into student values(?, ?)";
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setInt(1, num);
        statement.setString(2, name);
        System.out.println(statement);

        // 4. 执行 SQL 语句, insert, update, delete 都是通过 executeUpdate 来执行的.
        //    select 则是通过 executeQuery 来执行的.
        //    executeUpdate 的返回值是一个 整数 表示这个操作影响到几行~
        int n = statement.executeUpdate();
        System.out.println("n = " + n);

        // 5. 断开连接, 释放资源
        statement.close();
        connection.close();
    }
}
