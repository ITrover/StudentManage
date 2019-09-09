package dao;

import entity.Manager;
import entity.Student;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import utils.JDBCUtil;

import java.util.ArrayList;
import java.util.List;

public class ManageDao {
    private JdbcTemplate template = new JdbcTemplate(JDBCUtil.getDataSource());

    public void addStudent(Student stu){
          String sql="insert into student values(?,?,?,?,?)";
          template.update(sql,stu.getName(),stu.getSex(),stu.getAge(),stu.getSid(),stu.getMajor());
    }
    public void deleteByName(String name){
        String sql="delete from student where name = ?";
        template.update(sql,name);
    }
    public void deleteBySid(String sid){
        String sql="delete from student where sid = ?";
        template.update(sql,sid);
    }
   public Student findByName(String name){
        String sql="select * from student where name =?";
        return template.queryForObject(sql,new BeanPropertyRowMapper<Student>(Student.class),name);
   }
    public Student findBySid(String sid){
        String sql="select * from student where name =?";
        return template.queryForObject(sql,new BeanPropertyRowMapper<Student>(Student.class),sid);
    }
   public void updateBySid(Student stu){
         String sql="update student set name = ? ,sex = ?,age = ? ,sid = ?,major=?  where sid = ?";
         template.update(sql,stu.getName(),stu.getSex(),stu.getAge(),stu.getSid(),stu.getMajor(),stu.getSid());
   }
   public ArrayList<Student> findAllByName(String name){
        String sql="select * from student where name = ?";
        ArrayList<Student> list = new ArrayList<>();
        list = (ArrayList<Student>) template.query(sql,new BeanPropertyRowMapper<Student>(Student.class),name);
       return list;
   }
    public ArrayList<Student> findAllBySid(String sid){
        String sql="select * from student where name = ?";
        ArrayList<Student> list = new ArrayList<>();
        list = (ArrayList<Student>) template.query(sql,new BeanPropertyRowMapper<Student>(Student.class),sid);
        return list;
    }
   public ArrayList<Student> findAllByNameAndSid(String name, String sid){
           String sql="select * from student where name = ? AND sid = ?";
       ArrayList<Student> list = new ArrayList<>();
       list = (ArrayList<Student>) template.query(sql,new BeanPropertyRowMapper<Student>(Student.class),name,sid);
       return list;
   }
}
