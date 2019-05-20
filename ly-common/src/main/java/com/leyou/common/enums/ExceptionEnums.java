package com.leyou.common.enums;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public enum ExceptionEnums {
    PRIVICE_CAN_BE_NULL(400,"价格不能为空"),
    CATEGOTY_NOT_FOUND(404,"商品分类没有查到"),
    BRAND_NOT_FOUND(404, "品牌查询失败"),
    UPLOAD_FILE_ERROR(500,"文件上传失败"),
    ;
    private int code;
    private String msg;

}

