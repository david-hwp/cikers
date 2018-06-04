package com.cikers.wechat.mall.modules.sys.service;

import com.baomidou.mybatisplus.service.IService;
import com.cikers.wechat.mall.common.utils.R;
import com.cikers.wechat.mall.modules.sys.entity.SysUserTokenEntity;
import com.cikers.wechat.mall.common.utils.R;

/**
 * 用户Token
 * 
 * @author chenshun
 * @email sunlightcs@gmail.com
 * @date 2017-03-23 15:22:07
 */
public interface SysUserTokenService extends IService<SysUserTokenEntity> {

	/**
	 * 生成token
	 * @param userId  用户ID
	 */
	R createToken(long userId);

	/**
	 * 退出，修改token值
	 * @param userId  用户ID
	 */
	void logout(long userId);

}
