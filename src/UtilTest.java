import dao.LoginDao;
import dao.ManageDao;
import entity.Manager;
import entity.Student;
import javafx.scene.input.Mnemonic;
import org.junit.Test;
import utils.JDBCUtil;

import java.sql.*;
import java.util.ArrayList;

public class UtilTest {
    @Test
    public void test(){
        String serNmae="王五";
        String serSid = null;
        ArrayList<Student> list = null;
        ManageDao dao = new ManageDao();
        if(serNmae == null){
            list = dao.findAllBySid(serSid);
        }else if(serSid == null){
            list = dao.findAllByName(serNmae);
        }else if(serSid == null && serNmae ==null){
            System.out.println("空查询");
        }else {
            list = dao.findAllByNameAndSid(serNmae,serSid);
        }
        System.out.println(list);
    }

}
