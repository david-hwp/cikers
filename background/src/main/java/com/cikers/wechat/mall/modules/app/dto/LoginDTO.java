package com.cikers.wechat.mall.modules.app.dto;

import lombok.Data;

import java.io.Serializable;

/**
 * @author ： huangjikun
 * @version ： 创建时间 2018/4/24 20:24
 * 说明 : 小程序登录VO
 */
@Data
public class LoginDTO implements Serializable
{
    private static final long serialVersionUID = -4623155383279795378L;

    private String openid;              //用户唯一标识
    private int expires_in = 7200;      //凭证有效时间，单位：秒
    private String session_key;         //会话密匙
    private long exprexpiredTime;           //过期时间

    /**
     * 接口调用失败错误码
     */
    private Integer errcode;

    /**
     * 接口调用失败错误信息
     */
    private String errmsg;

    /**
     * 用户在开放平台的唯一标识符
     */
    private String unionid;

}
