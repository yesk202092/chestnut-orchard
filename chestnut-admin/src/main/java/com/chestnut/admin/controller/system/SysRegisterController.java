package com.chestnut.admin.controller.system;

import com.chestnut.admin.manager.biz.service.SysRegisterService;
import com.chestnut.admin.system.service.ISysConfigService;
import com.chestnut.common.core.controller.BaseController;
import com.chestnut.common.core.domain.AjaxResult;
import com.chestnut.common.core.domain.model.RegisterBody;
import com.chestnut.common.utils.StringUtils;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * 注册验证
 * 
 * @author chestnut
 */
@RestController
public class SysRegisterController extends BaseController
{
    @Autowired
    private SysRegisterService registerService;

    @Autowired
    private ISysConfigService configService;

    @PostMapping("/register")
    public AjaxResult register(@RequestBody RegisterBody user)
    {
        if (!("true".equals(configService.selectConfigByKey("sys.account.registerUser"))))
        {
            return error("当前系统没有开启注册功能！");
        }
        String msg = registerService.register(user);
        return StringUtils.isEmpty(msg) ? success() : error(msg);
    }
}
