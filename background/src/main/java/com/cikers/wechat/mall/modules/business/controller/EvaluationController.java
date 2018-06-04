package com.cikers.wechat.mall.modules.business.controller;

import java.util.Arrays;
import java.util.Map;

import com.cikers.wechat.mall.common.utils.R;
import com.cikers.wechat.mall.modules.business.entity.EvaluationEntity;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.cikers.wechat.mall.modules.business.service.EvaluationService;
import com.cikers.wechat.mall.common.utils.PageUtils;


/**
 * 评价信息
 *
 * @author hjk
 * @email 358236647@qq.com
 * @date 2018-04-19 20:26:15
 */
@RestController
@RequestMapping("business/evaluation")
public class EvaluationController {
    @Autowired
    private EvaluationService evaluationService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    @RequiresPermissions("business:evaluation:list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = evaluationService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
    @RequiresPermissions("business:evaluation:info")
    public R info(@PathVariable("id") Integer id){
			EvaluationEntity evaluation = evaluationService.selectById(id);

        return R.ok().put("evaluation", evaluation);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    @RequiresPermissions("business:evaluation:save")
    public R save(@RequestBody EvaluationEntity evaluation){
			evaluationService.insert(evaluation);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    @RequiresPermissions("business:evaluation:update")
    public R update(@RequestBody EvaluationEntity evaluation){
			evaluationService.updateById(evaluation);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    @RequiresPermissions("business:evaluation:delete")
    public R delete(@RequestBody Integer[] ids){
			evaluationService.deleteBatchIds(Arrays.asList(ids));

        return R.ok();
    }

}
