package cn.king02.dao;

import cn.king02.annotation.DataSource;
import cn.king02.entity.User;
import cn.king02.enumeration.DataSourceType;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @author: wjl@king.cn
 * @time: 2020/5/13 16:19
 * @version: 1.0.0
 * @description:
 */
public interface UserMapper {

    @DataSource
    @Insert("insert into tb_user ( `name` ) values ( #{name} )")
    boolean addUser(User user);

    @DataSource(name = DataSourceType.SLAVE)
    @Select("select * from tb_user")
    List<User> findAll();

}
