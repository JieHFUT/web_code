import com.mysql.cj.jdbc.MysqlDataSource;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: JIE
 * Date: 2022-10-24
 * Time: 22:44
 */
public class DBUtil {

    private static DataSource dataSource = null;

    private static DataSource getDataSource() {
        if (dataSource == null){
            dataSource = new MysqlDataSource();
            ((MysqlDataSource)dataSource).setURL("jdbc:mysql://127.0.0.1:3306/messagewall?characterEncoding=utf8&useSSL=false");
            ((MysqlDataSource)dataSource).setUser("root");
            ((MysqlDataSource)dataSource).setPassword("959452");
        }
        return dataSource;
    }

    public static Connection getConnection() throws SQLException {
        return getDataSource().getConnection();
    }


    public static void close(Connection connection, PreparedStatement statement, ResultSet resultSet) {
        if (connection != null) {
            try {
                resultSet.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        if (statement != null) {
            try {
                statement.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        if (resultSet != null){
            try {
                resultSet.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }




}
