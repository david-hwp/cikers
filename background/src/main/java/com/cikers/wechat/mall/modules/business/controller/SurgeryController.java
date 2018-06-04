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

import com.cikers.wechat.mall.modules.business.entity.SurgeryEntity;
import com.cikers.wechat.mall.modules.business.service.SurgeryService;
import com.cikers.wechat.mall.common.utils.PageUtils;
import com.cikers.wechat.mall.common.utils.R;



/**
 * 手术信息
 *
 * @author hjk
 * @email 358236647@qq.com
 * @date 2018-04-19 20:26:15
 */
@RestController
@RequestMapping("business/surgery")
public class SurgeryController {
    @Autowired
    private SurgeryService surgeryService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    @RequiresPermissions("business:surgery:list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = surgeryService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
    @RequiresPermissions("business:surgery:info")
    public R info(@PathVariable("id") Integer id){
			SurgeryEntity surgery = surgeryService.selectById(id);

        return R.ok().put("surgery", surgery);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    @RequiresPermissions("business:surgery:save")
    public R save(@RequestBody SurgeryEntity surgery){
			surgeryService.insert(surgery);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    @RequiresPermissions("business:surgery:update")
    public R update(@RequestBody SurgeryEntity surgery){
			surgeryService.updateById(surgery);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    @RequiresPermissions("business:surgery:delete")
    public R delete(@RequestBody Integer[] ids){
			surgeryService.deleteBatchIds(Arrays.asList(ids));

        return R.ok();
    }

}
