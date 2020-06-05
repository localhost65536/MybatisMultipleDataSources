package cn.king02.aspect;

import cn.king02.annotation.DataSource;
import cn.king02.datasource.DynamicDataSource;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;

/**
 * @author: wjl@king.cn
 * @time: 2020/5/13 17:04
 * @version: 1.0.0
 * @description:
 */
@Aspect
@Component
public class DataSourceAspect {

    @Pointcut("@annotation(cn.king02.annotation.DataSource)")
    public void dataSourcePointCut() {

    }

    /**
     * @author: wjl@king.cn
     * @createTime: 2020/5/29 17:49
     * @param: point
     * @return: java.lang.Object
     * @description: 环绕通知。根据方法上的注解动态切换数据源。
     */
    @Around("dataSourcePointCut()")
    public Object around(ProceedingJoinPoint point) throws Throwable {
        try {
            // 获取当前执行的方法
            MethodSignature signature = (MethodSignature) point.getSignature();
            Method method = signature.getMethod();
            // 获取方法上的@DataSource注解
            DataSource dataSource = method.getAnnotation(DataSource.class);

            // 切换整个系统的数据源.
            DynamicDataSource.setDataSource(dataSource.name());

            // 调用目标方法，返回目标方法的返回值
            return point.proceed();

        } finally {
            // 清空数据源类型
            DynamicDataSource.clearDataSource();
        }
    }

}
