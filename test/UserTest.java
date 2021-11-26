import com.mapper.UserMapper;
import com.pojo.User;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

public class UserTest {
    @Test
    public void QueryAllUsersTest(){
        ApplicationContext ac=new ClassPathXmlApplicationContext("applicationcontext-dao.xml");
        UserMapper userMapper= (UserMapper) ac.getBean("userMapper");
        List<User> userList=userMapper.QueryAllUsers();
        for (User u:userList){
            System.out.println(u);
        }
    }
    //传统Dao模式
    @Test
    public void QueryUserByIdTest(){
        ApplicationContext ac=new ClassPathXmlApplicationContext("applicationcontext-dao.xml");
        UserMapper userMapper= (UserMapper) ac.getBean("userMapper");
        User user=userMapper.QueryUserById(1);
        System.out.println(user);
    }
    //基于Mapper代理接口方法
    @Test
    public void QueryAllUsersTest1(){
        ApplicationContext ac=new ClassPathXmlApplicationContext("applicationcontext-dao.xml");
        SqlSessionFactory sqlSessionFactory= (SqlSessionFactory) ac.getBean("sqlSessionFactory");
        SqlSession session=sqlSessionFactory.openSession();
        UserMapper userMapper=session.getMapper(com.mapper.UserMapper.class);
        List<User> userList=userMapper.QueryAllUsers();
        for (User u:userList){
            System.out.println(u);
        }
        session.close();
    }
}
