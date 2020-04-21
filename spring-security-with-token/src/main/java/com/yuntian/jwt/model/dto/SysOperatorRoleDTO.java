package com.yuntian.jwt.model.dto;

import com.yuntian.jwt.model.entity.SysOperatorRole;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 后台系统-用户角色关系表(SysOperatorRole)DTO对象
 *
 * @author makejava
 * @since 2020-04-19 10:52:14
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class SysOperatorRoleDTO extends SysOperatorRole {
    private static final long serialVersionUID = 316590706067888749L;


}