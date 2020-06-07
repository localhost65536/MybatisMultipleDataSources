package cn.king02.datasource;

import cn.king02.enumeration.DataSourceType;

/**
 * @author: wjl@king.cn
 * @time: 2020/6/5 23:13
 * @version: 1.0.0
 * @description:
 */
public class DataSourceContextHolder {

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
