package com.chestnut;


import com.chestnut.common.config.AppStartupListener;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;

/**
 * SpringBoot方式 ApplicationMain 启动类
 *
 * @author yesk
 * @date 2022/12/11 12:06
 */
@SpringBootApplication
@EnableConfigurationProperties
public class AppApplication {
    public static void main(String[] args) {
        SpringApplication.run(AppApplication.class, args);
    }



    @Bean
    public AppStartupListener appStartupListener() {
        return new AppStartupListener();
    }


}
