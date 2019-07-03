package com.test;

/*@program: mybatis
 *@description: Junit4测试
 *@author: zeng
 *@create: 2019-07-03 19:35
 */

import com.Queue.QueueVo;
import com.dao.IUserDao;
import com.model.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;

import java.io.InputStream;
import java.util.List;


public class Test {

    private InputStream in;
    private SqlSessionFactoryBuilder builder;
    private SqlSessionFactory factory;
    private SqlSession sqlSession;
    private IUserDao userDao;
    @BeforeClass
    public static void init() throws Exception{
        System.out.println("@BeforeClass");
    }
    @Before
    public void setUp()throws Exception{
        //读取配置文件
        in= Resources.getResourceAsStream("SqlMapperConfig.xml");
        //创建SqlSessionFactory工厂
        // description:创建工厂，mybatis使用构建者模式--
        // 作用：把对象的创建细节隐藏，是使用者直接调用方法即可拿到对象
        builder=new SqlSessionFactoryBuilder();
        factory=builder.build(in);
        //使用工厂生产SqlSession对象 --使用工厂模式作用：解耦，降低类之间的依赖关系
        sqlSession=factory.openSession();
        //使用SqlSession对象创建DAO接口代理对象--代理模式
        // 作用：不修改源码的基础上，对已有方法的增强
        userDao=sqlSession.getMapper(IUserDao.class);
    }
    @After
    public void tearDown()throws Exception{
        //提交事务
        sqlSession.commit();
        //释放资源
        sqlSession.close();
        //关闭字符流
        in.close();
    }

    @AfterClass
    public static void destroy() throws Exception{

        System.out.println("@AfterClass");

    }
    @org.junit.Test
    public void testsaveUser() throws Exception{
        User user=new User();
        user.setUserid(101);
        user.setUsername("曾国藩--update");
        System.out.println("保存之前"+user);
        userDao.saveUser(user);
        System.out.println("保存之后"+user);
    }
   @org.junit.Test
    public void testdeleteUser(){
        userDao.deleteUser(101);
    }
    @org.junit.Test
    public void testupdateUser() {
        User user=new User();
        user.setUserid(103);
        user.setUsername("zxq");
        userDao.updateUser(user);
    }
    @org.junit.Test
    public void testfindAllUser() {
        List<User> users = userDao.findAllUser();
        for (User user : users) {
            System.out.println(user);
        }
    }
    @org.junit.Test
    public void testfindById(){
        User user= userDao.findById(102);
        System.out.println("查询一个用户"+user);
    }
    @org.junit.Test
    public void testfindByUsername(){
        List<User> users= userDao.findByUsername("曾");
        for (User user : users) {
            System.out.println(user);
        }
    }

    @org.junit.Test
    public void testfindTotall(){
       int count=userDao.findTotall();
        System.out.println("用户数："+count);
    }

    /**
     * 测试
     *
     */
    @org.junit.Test
    public void testQueueVo(){
        QueueVo vo=new QueueVo();
        User user=new User();
        user.setUsername("%曾%");
        vo.setUser(user);
       List<User> users= userDao.findUserByVo(vo);
       for (User u : users) {
           System.out.println(u);
       }

   }



}
