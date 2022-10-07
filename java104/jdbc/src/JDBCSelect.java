import com.mysql.jdbc.jdbc2.optional.MysqlDataSource;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class JDBCSelect {
    public static void main(String[] args) throws SQLException {
        // 查找数据库中的记录
        // 这个查找和前面的操作就不太一样了~~ 多了一个步骤, 要遍历结果集合~

        // 1. 创建数据源
        DataSource dataSource = new MysqlDataSource();
        ((MysqlDataSource)dataSource).setUrl("jdbc:mysql://127.0.0.1:3306/java104?characterEncoding=utf8&useSSL=false");
        ((MysqlDataSource)dataSource).setUser("root");
        ((MysqlDataSource)dataSource).setPassword("2222");

        // 2. 和数据库服务器建立连接
        Connection connection = dataSource.getConnection();

        // 3. (此处不输入条件了, 直接查找所有记录)

        // 4. 构造 SQL
        String sql = "select * from student";
        PreparedStatement statement = connection.prepareStatement(sql);

        // 5. 执行 SQL.
        //    此处要使用的是 executeQuery.
        //    executeUpdate 只能返回一个 int.
        //    executeQuery 返回的是一个 ResultSet 对象. 可以把这个对象视为是一个 "临时表"
        ResultSet resultSet = statement.executeQuery();

        // 6. 遍历临时表, 拿到里面的数据.
        //    resultSet 简单的当成一个类似于 "迭代器" 这样的东西来看待~
        //    next 如果没有到达末尾, 就是返回 true, 要继续循环.
        //    next 如果到达末尾, 就返回 false, 结束循环.
        while (resultSet.next()) {
            // 在这里就可以取这一行的数据了.
            // 通过 ResultSet 里面的 getXXX 方法, 来获取到这里指定的列.

            // 取 id, id 是整数, getInt
            int id = resultSet.getInt("id");
            // 取 name, name 是 String, getString
            String name = resultSet.getString("name");
            System.out.println(id + ": " + name);
        }

        // 7. 关闭连接, 释放资源
        resultSet.close();
        statement.close();
        connection.close();
    }
}
