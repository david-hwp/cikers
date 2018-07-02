package com.cikers.wechat.mall.modules.app.form;

import lombok.Data;

@Data
public class ProductForm {
    private String keyword;
    private String type;
    private Integer pageSize;
    private Integer pageIndex;
    private Integer offset;
}