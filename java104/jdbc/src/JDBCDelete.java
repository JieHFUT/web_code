import com.mysql.jdbc.jdbc2.optional.MysqlDataSource;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class JDBCDelete {
    public static void main(String[] args) throws SQLException {
        // 删除数据库中的数据. 代码的写法和前面的增加/修改 是类似的.

        // 1. 构造数据源
        DataSource dataSource = new MysqlDataSource();
        ((MysqlDataSource)dataSource).setUrl("jdbc:mysql://127.0.0.1:3306/java104?characterEncoding=utf8&useSSL=false");
        ((MysqlDataSource)dataSource).setUser("root");
        ((MysqlDataSource)dataSource).setPassword("2222");

        // 2. 建立连接
        Connection connection = dataSource.getConnection();

        // 3. 输入要删除的内容
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入要删除的学生 id: ");
        int id = scanner.nextInt();

        // 4. 构造 SQL
        String sql = "delete from student where id = ?";
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setInt(1, id);

        // 5. 执行 SQL
        int n = statement.executeUpdate();
        System.out.println("n = " + n);

        // 6. 关闭连接, 释放资源
        statement.close();
        connection.close();
    }
}
