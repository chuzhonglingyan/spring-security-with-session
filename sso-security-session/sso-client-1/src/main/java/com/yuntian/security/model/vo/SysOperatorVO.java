package com.yuntian.security.model.vo;

import java.util.Date;
import lombok.Data;
import lombok.EqualsAndHashCode;
import com.yuntian.security.model.entity.SysOperator;

/**
 * 后台系统-用户表(SysOperator)VO对象
 *
 * @author makejava
 * @since 2020-04-19 10:52:14
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class SysOperatorVO extends SysOperator {
    private static final long serialVersionUID = -61903401787138634L;

}