package cn.king02;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.Banner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author: wjl@king.cn
 * @time: 2020/5/29 17:19
 * @version: 1.0.0
 * @description:
 */
@MapperScan(basePackages = "cn.king02.dao")
@SpringBootApplication
// 下面的写法能解决多数据源导致的循环依赖
//@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
public class Demo02Application {
    public static void main(String[] args) {
        SpringApplication springApplication = new SpringApplication(Demo02Application.class);
        springApplication.setBannerMode(Banner.Mode.OFF);
        springApplication.run(args);
        System.out.println("启动成功 <================================");
    }
}
