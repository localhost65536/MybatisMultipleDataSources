package cn.king02.datasource;

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

        // 实现InitializingBean类就必须实现afterPropertiesSet()方法，这是Spring中Bean声明周期相关的方法。经测试此处可以不调用。
        //super.afterPropertiesSet();
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
