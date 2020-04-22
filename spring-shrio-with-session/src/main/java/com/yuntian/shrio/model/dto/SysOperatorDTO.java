package com.yuntian.shrio.model.dto;

import com.yuntian.shrio.model.entity.SysOperator;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 后台系统-用户表(SysOperator)DTO对象
 *
 * @author makejava
 * @since 2020-04-19 10:52:13
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class SysOperatorDTO extends SysOperator {
    private static final long serialVersionUID = 715289452385406227L;


    private boolean rememberMe;

}