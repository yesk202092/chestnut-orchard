package com.chestnut.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

/**
 * @author yesk
 */
@RestController
@Slf4j
public class IndexController {
    /**
     * 首页
     *
     * @author yesk
     * @date 2022/7/8 14:22
     **/
    @GetMapping("/index")
    public String index() throws IOException {
        return "欢迎使用后台管理框架，请通过前端地址访问。";
    }
}
