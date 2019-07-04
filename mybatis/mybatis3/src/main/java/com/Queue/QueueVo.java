package com.Queue;

/*@program: mybatis
 *@description: 传递pojo包装类型
 *@author: zeng
 *@create: 2019-07-03 22:05
 */
/**
 *  基本步骤：
 *  1.IUserDAO写方法 -->List<User> findUserByVo(QueueVo vo);
 *  2.UserDao.xml --ONGL表达式
 *  写<select id="findUserByVo" parameterType="com.Queue.QueueVo" resultType="com.model.User">
 *       select * from user where username like #{user.username}
 * </select>
 * 3.在Test.class写测试方法
 * 4.目的：官方：由多个对象组成一个查询条件
 *    将单个查询条件组织起来包装成pojo对象
 */

import com.model.User;

public class QueueVo {

    User user;
    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }


}
