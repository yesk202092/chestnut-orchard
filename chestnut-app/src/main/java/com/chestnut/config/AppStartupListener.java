
package com.chestnut.config;

import cn.hutool.core.date.DatePattern;
import cn.hutool.core.date.DateUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.context.ApplicationContext;

import javax.annotation.Resource;
import java.lang.management.ManagementFactory;
import java.net.InetAddress;
import java.util.Date;

/**
 * @author yesk
 * @classname : AppStartupListener
 * @description : 启动日志打印
 * @date 2022/10/19 2:47
 */
@Slf4j
public class AppStartupListener implements ApplicationRunner {

    /**
     * 团队名称
     */
    public static final String TEAM_NAME = "chestnut";
    /**
     * 上下文对象实例
     */
    @Resource
    private ApplicationContext ctx;
    /**
     * 应用启动信息常量
     **/
    public static final String APP_START_INFO =
            "\n" +
                    "==============================================================\n" +
                    "\tApp:\t{}\n" +
                    "\tState:\tapp is running\n" +
                    "\tPID:\t{}\n" +
                    "\tDate:\tstarted at {}\n" +
                    "\tAuth:\t" + TEAM_NAME + "\n" +
                    "\tURLs:\thttp://{}:{}{}\n" +
                    "==============================================================";

    /**
     * Callback used to run the bean.
     *
     * @param args incoming application arguments
     * @throws Exception on error
     */
    @Override
    public void run(ApplicationArguments args) throws Exception {
        String appName = ctx.getEnvironment().getProperty("spring.application.name");
        String appJvmName = ManagementFactory.getRuntimeMXBean().getName();
        String appHost = InetAddress.getLocalHost().getHostAddress();
        String appPort = ctx.getEnvironment().getProperty("server.port");
        String appPath = ctx.getEnvironment().getProperty("server.servlet.context-path");
        String appStartupDate = DateUtil.format(new Date(ctx.getStartupDate()), DatePattern.NORM_DATETIME_MS_PATTERN);
        log.info(APP_START_INFO, appName, appJvmName.split("@")[0], appStartupDate, appHost, appPort, (appPath == null ? "" : appPath));
    }
}
