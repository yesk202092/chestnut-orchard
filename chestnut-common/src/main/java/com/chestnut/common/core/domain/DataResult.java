package com.chestnut.common.core.domain;

import com.chestnut.common.constant.HttpStatus;

import java.io.Serializable;

/**
 * 响应信息主体
 *
 * @author chestnut
 */
public class DataResult<T> implements Serializable
{
    private static final long serialVersionUID = 1L;

    /** 成功 */
    public static final int SUCCESS = HttpStatus.SUCCESS;

    /** 失败 */
    public static final int FAIL = HttpStatus.ERROR;

    private int code;

    private String msg;

    private T data;

    public static <T> DataResult<T> ok()
    {
        return restResult(null, SUCCESS, "操作成功");
    }

    public static <T> DataResult<T> ok(T data)
    {
        return restResult(data, SUCCESS, "操作成功");
    }

    public static <T> DataResult<T> ok(T data, String msg)
    {
        return restResult(data, SUCCESS, msg);
    }

    public static <T> DataResult<T> fail()
    {
        return restResult(null, FAIL, "操作失败");
    }

    public static <T> DataResult<T> fail(String msg)
    {
        return restResult(null, FAIL, msg);
    }

    public static <T> DataResult<T> fail(T data)
    {
        return restResult(data, FAIL, "操作失败");
    }

    public static <T> DataResult<T> fail(T data, String msg)
    {
        return restResult(data, FAIL, msg);
    }

    public static <T> DataResult<T> fail(int code, String msg)
    {
        return restResult(null, code, msg);
    }

    private static <T> DataResult<T> restResult(T data, int code, String msg)
    {
        DataResult<T> apiResult = new DataResult<>();
        apiResult.setCode(code);
        apiResult.setData(data);
        apiResult.setMsg(msg);
        return apiResult;
    }

    public int getCode()
    {
        return code;
    }

    public void setCode(int code)
    {
        this.code = code;
    }

    public String getMsg()
    {
        return msg;
    }

    public void setMsg(String msg)
    {
        this.msg = msg;
    }

    public T getData()
    {
        return data;
    }

    public void setData(T data)
    {
        this.data = data;
    }

    public static <T> Boolean isError(DataResult<T> ret)
    {
        return !isSuccess(ret);
    }

    public static <T> Boolean isSuccess(DataResult<T> ret)
    {
        return DataResult.SUCCESS == ret.getCode();
    }
}
