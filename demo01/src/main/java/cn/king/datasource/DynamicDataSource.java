package cn.king.datasource;

import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;

/**
 * @author: wjl@king.cn
 * @time: 2020/5/13 22:40
 * @version: 1.0.0
 * @description: 动态获取数据源。
 * AbstractRoutingDataSource 抽象类实现了 javax.sql.DataSource 接口.
 */
public class DynamicDataSource extends AbstractRoutingDataSource {

    @Override
    protected Object determineCurrentLookupKey() {
        return DataSourceContextHolder.getDBType();
    }

}