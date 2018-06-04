package com.cikers.wechat.mall.modules.business.controller;

import java.util.Arrays;
import java.util.Map;

import com.cikers.wechat.mall.common.utils.R;
import com.cikers.wechat.mall.modules.business.service.OrganizationService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.cikers.wechat.mall.modules.business.entity.OrganizationEntity;
import com.cikers.wechat.mall.common.utils.PageUtils;


/**
 * 机构表
 *
 * @author hjk
 * @email 358236647@qq.com
 * @date 2018-04-19 20:04:44
 */
@RestController
@RequestMapping("business/organization")
public class OrganizationController {
    @Autowired
    private OrganizationService organizationService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    @RequiresPermissions("business:organization:list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = organizationService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
    @RequiresPermissions("business:organization:info")
    public R info(@PathVariable("id") Integer id){
			OrganizationEntity organization = organizationService.selectById(id);

        return R.ok().put("organization", organization);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    @RequiresPermissions("business:organization:save")
    public R save(@RequestBody OrganizationEntity organization){
			organizationService.insert(organization);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    @RequiresPermissions("business:organization:update")
    public R update(@RequestBody OrganizationEntity organization){
			organizationService.updateById(organization);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    @RequiresPermissions("business:organization:delete")
    public R delete(@RequestBody Integer[] ids){
			organizationService.deleteBatchIds(Arrays.asList(ids));

        return R.ok();
    }

}
