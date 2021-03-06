package com.dao;

/*@program: mybatis
 *@description: 用户持久层接口
 *@author: zeng
 *@create: 2019-06-24 22:00
 */

import com.model.User;
import org.apache.ibatis.annotations.Select;

import java.util.List;
public interface IUserDao {

     @Select("select * from user")
     List<User> findAllUser();

}
