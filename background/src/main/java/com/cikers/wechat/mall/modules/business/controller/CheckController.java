package com.cikers.wechat.mall.modules.business.controller;

import java.util.Arrays;
import java.util.Map;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.cikers.wechat.mall.modules.business.entity.CheckEntity;
import com.cikers.wechat.mall.modules.business.service.CheckService;
import com.cikers.wechat.mall.common.utils.PageUtils;
import com.cikers.wechat.mall.common.utils.R;



/**
 * 审核信息
 *
 * @author hjk
 * @email 358236647@qq.com
 * @date 2018-04-19 20:26:15
 */
@RestController
@RequestMapping("business/check")
public class CheckController {
    @Autowired
    private CheckService checkService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    @RequiresPermissions("business:check:list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = checkService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
    @RequiresPermissions("business:check:info")
    public R info(@PathVariable("id") Integer id){
			CheckEntity check = checkService.selectById(id);

        return R.ok().put("check", check);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    @RequiresPermissions("business:check:save")
    public R save(@RequestBody CheckEntity check){
			checkService.insert(check);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    @RequiresPermissions("business:check:update")
    public R update(@RequestBody CheckEntity check){
			checkService.updateById(check);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    @RequiresPermissions("business:check:delete")
    public R delete(@RequestBody Integer[] ids){
			checkService.deleteBatchIds(Arrays.asList(ids));

        return R.ok();
    }

}
