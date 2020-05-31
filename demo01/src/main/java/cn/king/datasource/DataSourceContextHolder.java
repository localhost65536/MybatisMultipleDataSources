package cn.king.datasource;

/**
 * @author: wjl@king.cn
 * @time: 2020/5/13 22:40
 * @version: 1.0.0
 * @description:
 */
public class DataSourceContextHolder {

    private static final ThreadLocal<String> contextHolder = new ThreadLocal<>();

    public static void setDBType(String dbType) {
        contextHolder.set(dbType);
    }

    public static String getDBType() {
        return ((String) contextHolder.get());
    }

    public static void clearDBType() {
        contextHolder.remove();
    }

}