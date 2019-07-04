package com.dao;

/*@program: mybatis
 *@description: 用户持久层接口
 *@author: zeng
 *@create: 2019-06-24 22:00
 */

import com.model.User;
import com.Queue.QueueVo;

import javax.jws.soap.SOAPBinding;
import java.util.List;

public interface IUserDao {

    /**
     * 查找用户
     * @return List<User>
     */
    List<User> findAllUser();

    /**
     * 保持用户
     * @param user
     */
    void saveUser(User user);

    /**
     * 更新用户
     * @param user
     */
    void updateUser(User user);

    /**
     * 根据userid删除用户
     * @param userid
     */
    void deleteUser(int userid);

    /**
     * 根据userid查找用户
     * @param userid
     * @return
     */
    User findById(int userid);

    /**
     * 根据username模糊查找
     * @param username
     * @return
     */
    List<User> findByUsername(String username);

    /**
     * 查询用户数
     * @return
     */
    int findTotall();

    /**
     * 根据QueueVo的条件查询用户
     * @param vo
     * @return
     */
    List<User> findUserByVo(QueueVo vo);



}
