package com.chan.config.peoperties;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @author chan
 * @create 2020-04-20 21:08
 *
 * 绑定外部配置文件中的数据源
 *
 * 方式一
 *      1.配置文件编写数据源；
 *      2.开启注入自动数据 @EnableConfigurationProperties(value = GetConfigProperties.class)
 *      3.声明为组件 @Component
 *      4.即可获取对象使用
 */
@Data   //使用lombok简化了set、get以及toString等方法
@Component
@ConfigurationProperties(prefix = "config.properties")
public class GetConfigProperties {

    private String url;
    private String username;
    private String password;
}
