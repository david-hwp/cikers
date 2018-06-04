package com.cikers.wechat.mall.modules.business.controller;

import java.util.Arrays;
import java.util.Map;

import com.cikers.wechat.mall.common.utils.R;
import com.cikers.wechat.mall.modules.business.entity.DictionaryEntity;
import com.cikers.wechat.mall.modules.business.service.DictionaryService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.cikers.wechat.mall.common.utils.PageUtils;


/**
 * 字典信息
 *
 * @author hjk
 * @email 358236647@qq.com
 * @date 2018-04-19 20:26:15
 */
@RestController
@RequestMapping("business/dictionary")
public class DictionaryController {
    @Autowired
    private DictionaryService dictionaryService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    @RequiresPermissions("business:dictionary:list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = dictionaryService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
    @RequiresPermissions("business:dictionary:info")
    public R info(@PathVariable("id") Integer id){
			DictionaryEntity dictionary = dictionaryService.selectById(id);

        return R.ok().put("dictionary", dictionary);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    @RequiresPermissions("business:dictionary:save")
    public R save(@RequestBody DictionaryEntity dictionary){
			dictionaryService.insert(dictionary);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    @RequiresPermissions("business:dictionary:update")
    public R update(@RequestBody DictionaryEntity dictionary){
			dictionaryService.updateById(dictionary);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    @RequiresPermissions("business:dictionary:delete")
    public R delete(@RequestBody Integer[] ids){
			dictionaryService.deleteBatchIds(Arrays.asList(ids));

        return R.ok();
    }

}
