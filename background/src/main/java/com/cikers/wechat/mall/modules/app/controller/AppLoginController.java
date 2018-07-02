package com.cikers.wechat.mall.modules.app.controller;


import com.cikers.wechat.mall.common.utils.R;
import com.cikers.wechat.mall.modules.app.dto.LoginDTO;
import com.cikers.wechat.mall.modules.app.utils.JwtUtils;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;

/**
 * APP登录授权
 *
 * 作者： huangjikun
 * 时间： 2017-03-23 15:31
 */
@RestController
@RequestMapping("/app")
//@Api("APP登录接口")
@Slf4j
public class AppLoginController {

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private JwtUtils jwtUtils;

    private static final String appid = "";	    //微信小程序appid
    private static final String secret = "";	//微信小程序密钥
    private static final String grant_type = "authorization_code";





    /**
     * 小程序登录
     */
    @PostMapping("login")
//    @ApiOperation("登录")
    public R login(String code){

        if (StringUtils.isBlank(code))
        {
            return R.error("code不能为空");
        }
        //拼接参数
        String param = "?grant_type=" + grant_type + "&appid=" + appid + "&secret=" + secret + "&js_code=" + code;

        String url = "https://api.weixin.qq.com/sns/jscode2session" + param;
        //get json数据
        LoginDTO dto = restTemplate.getForEntity(url, LoginDTO.class).getBody();
        log.info("小程序登录接口返回参数：{}", dto.toString());

        if (dto.getErrcode() != null) {
            //返回异常信息
            return R.error(dto.getErrmsg());
        }

        Map<String, Object> map = new HashMap<>();
        map.put("openId", dto.getOpenid());
        map.put("sessionKey", dto.getSession_key());

        return R.ok(map);
    }

    /**
     * 小程序登录
     */
    @PostMapping("userLogin")
//    @ApiOperation("登录")
    public R userLogin(String username,String password){

        if (StringUtils.isBlank(username))
        {
            return R.error("username不能为空");
        }
        String token = jwtUtils.generateToken(1);

        return R.ok(token);
    }

}
