package com.test;

/*@program: mybatis
 *@description: Test1测试类--入门案例1
 *@author: zeng
 *@create: 2019-06-24 22:33
 */

import com.dao.IUserDao;
import com.model.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import java.io.InputStream;
import java.util.List;


public class Test1{

    public static void main(String []arg) throws Exception{
    //读取配置文件
    InputStream in= Resources.getResourceAsStream("SqlMapperConfig.xml");
    //创建SqlSessionFactory工厂
    // description:创建工厂，mybatis使用构建者模式--
    // 作用：把对象的创建细节隐藏，是使用者直接调用方法即可拿到对象
    SqlSessionFactoryBuilder builder=new SqlSessionFactoryBuilder();
    SqlSessionFactory factory=builder.build(in);
    //使用工厂生产SqlSession对象 --使用工厂模式作用：解耦，降低类之间的依赖关系
    SqlSession session=factory.openSession();
    //使用SqlSession对象创建DAO接口代理对象--代理模式
    // 作用：不修改源码的基础上，对已有方法的增强
    IUserDao userDao=session.getMapper(IUserDao.class);
    //使用代理对象执行方法
        List<User> users=userDao.findAllUser();
        for (User user:users){
            System.out.println(user);
        }
        //释放资源
       session.close();
       in.close();
    }
}
