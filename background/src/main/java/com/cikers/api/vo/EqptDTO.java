package com.cikers.api.vo;

import lombok.Data;

import java.util.List;

/**
 * Created by WeiPing He on 2018/6/4 01:27.
 * Email: weiping_he@hansight.com
 */
@Data
public class EqptDTO {
    private Integer e;
    private String msg;
    private List<EqptProduct> data;
}
