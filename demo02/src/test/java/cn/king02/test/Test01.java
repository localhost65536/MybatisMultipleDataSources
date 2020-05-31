package cn.king02.test;

import cn.king02.Demo02Application;
import cn.king02.dao.UserMapper;
import cn.king02.entity.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

/**
 * @author: wjl@king.cn
 * @time: 2020/5/29 17:24
 * @version: 1.0.0
 * @description:
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = Demo02Application.class)
public class Test01 {

    @Resource
    private UserMapper userMapper;

    @Test
    public void test01(){
        System.out.println(userMapper.findAll());
    }

    @Test
    public void test02(){
        User user = new User();
        user.setName("Mike");
        System.out.println(userMapper.addUser(user));
    }




}
