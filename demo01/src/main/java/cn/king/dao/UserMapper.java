package cn.king.dao;


import cn.king.domain.User;

import java.util.List;

/**
 * @author: wjl@king.cn
 * @time: 2020/5/13 22:32
 * @version: 1.0.0
 * @description:
 */
public interface UserMapper {

    List<User> findAll();

}
