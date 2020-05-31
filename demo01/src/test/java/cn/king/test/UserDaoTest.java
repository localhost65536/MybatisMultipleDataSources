package cn.king.test;

import cn.king.dao.UserMapper;
import cn.king.datasource.DataSourceContextHolder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * @author: wjl@king.cn
 * @time: 2020/5/29 16:37
 * @version: 1.0.0
 * @description:
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({
        "classpath:spring/applicationContext-dao.xml",
        "classpath:spring/applicationContext-core.xml",
        "classpath:spring/applicationContext-trans.xml"
})
public class UserDaoTest {

    @Autowired
    private UserMapper userMapper;

    // 默认数据源
    @Test
    public void test01(){
        DataSourceContextHolder.clearDBType();
        System.out.println(userMapper.findAll());
    }

    // 主
    @Test
    public void test02(){
        DataSourceContextHolder.clearDBType();
        DataSourceContextHolder.setDBType("dataSourceMaster");
        System.out.println(userMapper.findAll());
    }

    // 从
    @Test
    public void test03(){
        DataSourceContextHolder.clearDBType();
        DataSourceContextHolder.setDBType("dataSourceSlave");
        System.out.println(userMapper.findAll());
    }

}
