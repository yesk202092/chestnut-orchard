package com.chestnut;

import com.chestnut.common.config.AppStartupListener;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.annotation.Bean;

/**
 * 启动程序
 * 
 * @author chestnut
 */
@SpringBootApplication(exclude = { DataSourceAutoConfiguration.class })
public class AdminApplication
{
    public static void main(String[] args)
    {
        // System.setProperty("spring.devtools.restart.enabled", "false");
        SpringApplication.run(AdminApplication.class, args);
    }

    @Bean
    public AppStartupListener appStartupListener() {
        return new AppStartupListener();
    }
}
