package com.cikers.wechat.mall.modules.business.controller;

import java.util.Arrays;
import java.util.Map;

import com.cikers.wechat.mall.common.utils.R;
import com.cikers.wechat.mall.modules.business.entity.ReceiveDoctorEntity;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.cikers.wechat.mall.modules.business.service.ReceiveDoctorService;
import com.cikers.wechat.mall.common.utils.PageUtils;


/**
 * 订单关联接单医生信息
 *
 * @author hjk
 * @email 358236647@qq.com
 * @date 2018-04-19 20:26:15
 */
@RestController
@RequestMapping("business/receivedoctor")
public class ReceiveDoctorController {
    @Autowired
    private ReceiveDoctorService receiveDoctorService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    @RequiresPermissions("business:receivedoctor:list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = receiveDoctorService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
    @RequiresPermissions("business:receivedoctor:info")
    public R info(@PathVariable("id") Integer id){
			ReceiveDoctorEntity receiveDoctor = receiveDoctorService.selectById(id);

        return R.ok().put("receiveDoctor", receiveDoctor);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    @RequiresPermissions("business:receivedoctor:save")
    public R save(@RequestBody ReceiveDoctorEntity receiveDoctor){
			receiveDoctorService.insert(receiveDoctor);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    @RequiresPermissions("business:receivedoctor:update")
    public R update(@RequestBody ReceiveDoctorEntity receiveDoctor){
			receiveDoctorService.updateById(receiveDoctor);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    @RequiresPermissions("business:receivedoctor:delete")
    public R delete(@RequestBody Integer[] ids){
			receiveDoctorService.deleteBatchIds(Arrays.asList(ids));

        return R.ok();
    }

}
