package com.cikers.wechat.mall.modules.app.dto;

import com.cikers.wechat.mall.modules.app.entity.EquipmentEntity;
import lombok.Data;

import java.util.List;

/**
 * Created by WeiPing He on 2018/6/4 01:27.
 * Email: weiping_he@hansight.com
 */
@Data
public class EquipmentDTO {
    private Integer e;
    private String msg;
    private List<EquipmentEntity> data;
}
