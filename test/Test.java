import com.entity.User;
import com.mapper.UserMapper;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.*;
import org.junit.After;
import org.junit.Before;

import java.io.InputStream;
import java.util.List;

public class Test {
    private InputStream inputStream;
    private SqlSession sqlSession;
    private UserMapper userMapper;
    /*
    * 初始化
    * */
    @Before
    public void init() throws Exception{
        //1.读取配置文件
        inputStream = Resources.getResourceAsStream("mybatis-config.xml");
        //2.创建SqlSessionFactory工厂
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        //3.使用工厂生产SqlSession对象
        sqlSession = sqlSessionFactory.openSession();
        //4.使用SqlSession创建Dao接口的代理对象
        userMapper = sqlSession.getMapper(UserMapper.class);
    }
    @After
    public void destroy() throws Exception{
        //6.提交事务
        sqlSession.commit();
        //7.释放资源
        sqlSession.close();
        inputStream.close();
    }
    /*
    * 测试全查
    * */
    @org.junit.Test
    public void userList(){
        //5.使用代理对象执行方法
        List<User> users = userMapper.userList();
        for (User user:users){
            System.out.println(user);
        }
    }
    /*
    * 回显
    * */
    @org.junit.Test
    public void echoUser(){
        //5.使用代理对象执行方法
        User user = userMapper.echoUser(203);
        System.out.println(user);
    }
    /*
    * 测试删除
    * */
    @org.junit.Test
    public void deleteUser(){
        //5.使用代理对象执行方法
        userMapper.deleteUser(197);
    }
    /*
    *
    * 测试添加
    * */
    @org.junit.Test
    public void insertUser(){
        //5.使用代理对象执行方法
        User user = new User();
        user.setName("JOJO");
        user.setAge("17");
        user.setHobby("ORAORAORA");
        userMapper.insertUser(user);
    }
    /*
    * 测试修改
    * */
    @org.junit.Test
    public void updateUser(){
        //5.使用代理对象执行方法
        User user = new User();
        user.setUser_id(203);
        user.setName("DIO");
        user.setAge("98");
        user.setHobby("吃面包");
        userMapper.updateUser(user);
    }
}
