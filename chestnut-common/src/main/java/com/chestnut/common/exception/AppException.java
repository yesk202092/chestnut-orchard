
package com.chestnut.common.exception;

import cn.hutool.core.util.StrUtil;
import com.chestnut.common.enums.AppExceptionEnum;
import lombok.Getter;
import lombok.Setter;

/**
 * 通用异常
 *
 * @author yesk
 * @date 2020/4/8 15:54
 */
@Getter
@Setter
public class AppException extends RuntimeException {

    private Integer code;

    private String msg;

    public AppException() {
        super("服务器异常");
        this.code = 500;
        this.msg = "服务器异常";
    }

    public AppException(String msg, Object... arguments) {
        super(StrUtil.format(msg, arguments));
        this.code = 500;
        this.msg = StrUtil.format(msg, arguments);
    }

    public AppException(Integer code, String msg, Object... arguments) {
        super(StrUtil.format(msg, arguments));
        this.code = code;
        this.msg = StrUtil.format(msg, arguments);
    }

    public AppException(AppException commonExceptionEnum) {
        super(commonExceptionEnum.getMessage());
        this.code = commonExceptionEnum.getCode();
        this.msg = commonExceptionEnum.getMessage();
    }

    public AppException(AppExceptionEnum error401) {
    }
}
