package dao;

import entity.Manager;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import utils.JDBCUtil;

public class LoginDao {
    private JdbcTemplate template = new JdbcTemplate(JDBCUtil.getDataSource());
    /**
     * 登录方法
     * @param loginManager 只有用户名和密码
     * @return Manager包含用户全部数据,没有查询到，返回null
     */
    public Manager login(Manager loginManager){
        try {
            //1.编写sql
            String sql = "select * from manager where username = ? and password = ?";
            //2.调用query方法
            Manager Manager = template.queryForObject(sql,
                    new BeanPropertyRowMapper<Manager>(Manager.class),
                    loginManager.getUsername(), loginManager.getPassword());
            return Manager;
        } catch (DataAccessException e) {
            e.printStackTrace();//记录日志
            return null;
        }
    }
}
