package com.chan.config.peoperties;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * @author chan
 * @create 2020-04-20 21:24
 *
 * 绑定外部配置文件中的数据源
 *
 * 方式二
 *      1.配置文件编写数据源；
 *      2.@Value("${user.name}")注解逐个注入数据源
 *      3.声明为组件 @Component
 */
@Data
@Component
public class UserProperties {

    @Value("${user.name}")
    private String name;
    @Value("${user.age}")
    private int age;
    @Value("${user.sex}")
    private String sex;
}
