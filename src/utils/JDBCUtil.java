package utils;

import com.alibaba.druid.pool.DruidDataSourceFactory;

import javax.sql.DataSource;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

public class JDBCUtil {
    private static DataSource ds;
    static {
        try {
            //加载配置文件
            Properties pro=new Properties();
            //通过反射找到资源文件
            InputStream is= JDBCUtil.class.getClassLoader().getResourceAsStream("druid.properties");
            pro.load(is);
            //初始化连接对象
            ds = DruidDataSourceFactory.createDataSource(pro);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 获取连接池对象
     * @return
     */
    public static DataSource getDataSource() {
        return ds;
    }

    /**
     * 获取Connection对象
     * @return
     * @throws SQLException
     */
    public static Connection getConnection() throws SQLException {
        return ds.getConnection();
    }
}
