package com.cikers.wechat.mall.modules.business.controller;

import java.util.Arrays;
import java.util.Map;

import com.cikers.wechat.mall.common.utils.R;
import com.cikers.wechat.mall.modules.business.entity.DoctorEntity;
import com.cikers.wechat.mall.modules.business.service.DoctorService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.cikers.wechat.mall.common.utils.PageUtils;


/**
 * 医生表
 *
 * @author hjk
 * @email 358236647@qq.com
 * @date 2018-04-19 20:04:44
 */
@RestController
@RequestMapping("business/doctor")
public class DoctorController {
    @Autowired
    private DoctorService doctorService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    @RequiresPermissions("business:doctor:list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = doctorService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
    @RequiresPermissions("business:doctor:info")
    public R info(@PathVariable("id") Integer id){
			DoctorEntity doctor = doctorService.selectById(id);

        return R.ok().put("doctor", doctor);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    @RequiresPermissions("business:doctor:save")
    public R save(@RequestBody DoctorEntity doctor){
			doctorService.insert(doctor);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    @RequiresPermissions("business:doctor:update")
    public R update(@RequestBody DoctorEntity doctor){
			doctorService.updateById(doctor);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    @RequiresPermissions("business:doctor:delete")
    public R delete(@RequestBody Integer[] ids){
			doctorService.deleteBatchIds(Arrays.asList(ids));

        return R.ok();
    }

}
