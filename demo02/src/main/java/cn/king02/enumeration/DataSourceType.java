package cn.king02.enumeration;

/**
 * @author: wjl@king.cn
 * @time: 2020/5/13 16:02
 * @version: 1.0.0
 * @description: 数据源类型的枚举。
 * 枚举就是一个 特殊的 抽象类 类, 枚举类中的枚举元素实际上就是 这个类的静态实例对象。
 */
public enum DataSourceType {

    MASTER,
    SLAVE;

    // 数据源类型
    private String dataSourceType;

}
