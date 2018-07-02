package com.cikers.wechat.mall.common.utils;

import lombok.Data;
import org.apache.http.HttpStatus;

import java.util.HashMap;
import java.util.Map;

/**
 * 返回数据
 *
 * @author chenshun
 * @email sunlightcs@gmail.com
 * @date 2016年10月27日 下午9:59:27
 */
@Data
public class BaseResp {
    private int e;
    private String msg;
    private Object data;
    private static final long serialVersionUID = 1L;

    public BaseResp() {
        this.e = 0;
        this.msg = "success";
    }

    public static BaseResp error() {
        return error(HttpStatus.SC_INTERNAL_SERVER_ERROR, "未知异常，请联系管理员");
    }

    public static BaseResp error(String msg) {
        return error(HttpStatus.SC_INTERNAL_SERVER_ERROR, msg);
    }

    public static BaseResp error(int code, String msg) {
        BaseResp r = new BaseResp();
        r.setE(code);
        r.setMsg(msg);
        return r;
    }

    public static BaseResp ok(String msg) {
        BaseResp r = new BaseResp();
        r.setMsg(msg);
        return r;
    }

    public static BaseResp ok(Object object) {
        BaseResp r = new BaseResp();
        r.setData(object);
        return r;
    }

    public static BaseResp ok() {
        return new BaseResp();
    }

}
