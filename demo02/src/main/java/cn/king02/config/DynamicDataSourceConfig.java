package cn.king02.config;


import cn.king02.datasource.DynamicDataSource;
import cn.king02.enumeration.DataSourceType;
import com.alibaba.druid.spring.boot.autoconfigure.DruidDataSourceBuilder;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.DependsOn;
import org.springframework.context.annotation.Primary;

import javax.sql.DataSource;
import java.util.HashMap;
import java.util.Map;

/**
 * 多数据源配置信息
 *
 * @author: wjl@king.cn
 * @time: 2020/2/10 9:47
 * @since: 1.0
 */
@Configuration
public class DynamicDataSourceConfig {

    // 配置数据源
    @Bean
    @ConfigurationProperties("spring.datasource.druid.ds-master")
    public DataSource masterDataSource() {
        return DruidDataSourceBuilder.create().build();
    }

    // 配置数据源
    @Bean
    @ConfigurationProperties("spring.datasource.druid.ds-slave")
    public DataSource slaveDataSource() {
        return DruidDataSourceBuilder.create().build();
    }

    // 配置动态数据源
    @Bean
    // 有多个同类型Bean时，优先注入带有@Primary注解的Bean。必须指定。因为DynamicDataSource也是一个DataSource.
    @Primary
    // 该注解用于声明当前bean依赖于另外一个bean。所依赖的bean会被容器确保在当前bean实例化之前被实例化.
    // 该注解用于解决循环依赖
    @DependsOn({"masterDataSource","slaveDataSource"})
    public DynamicDataSource dataSource(DataSource masterDataSource, DataSource slaveDataSource) {
        Map<Object, Object> targetDataSources = new HashMap<>();
        targetDataSources.put(DataSourceType.MASTER, masterDataSource);
        targetDataSources.put(DataSourceType.SLAVE, slaveDataSource);
        // 传入所有的数据源. 以及一个默认的数据源.
        return new DynamicDataSource(masterDataSource, targetDataSources);
    }

}
