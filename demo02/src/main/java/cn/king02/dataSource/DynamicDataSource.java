package cn.king02.dataSource;

import cn.king02.enumeration.DataSourceType;
import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;

import javax.sql.DataSource;
import java.util.Map;

/**
 * @author: wjl@king.cn
 * @time: 2020/5/13 17:00
 * @version: 1.0.0
 * @description: 动态数据源.
 * AbstractRoutingDataSource 抽象类实现了 javax.sql.DataSource 接口.
 */
public class DynamicDataSource extends AbstractRoutingDataSource {

    public DynamicDataSource(DataSource defaultTargetDataSource, Map<Object, Object> targetDataSources) {
        // 默认的数据源。将参数赋值到父类的属性中。
        super.setDefaultTargetDataSource(defaultTargetDataSource);
        // 所有的数据源
        super.setTargetDataSources(targetDataSources);
        super.afterPropertiesSet();
    }

    @Override
    protected Object determineCurrentLookupKey() {
        return getDataSource();
    }


    private static final ThreadLocal<DataSourceType> contextHolder = new ThreadLocal<>();

    public static void setDataSource(DataSourceType dataSource) {
        contextHolder.set(dataSource);
    }

    public static DataSourceType getDataSource() {
        return contextHolder.get();
    }

    public static void clearDataSource() {
        contextHolder.remove();
    }

}
