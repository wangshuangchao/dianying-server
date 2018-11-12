package com.mugua.dianying.entity;

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
import java.io.Serializable;

import com.baomidou.mybatisplus.annotations.Version;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 
 * </p>
 *
 * @author xiaobai123
 * @since 2018-11-06
 */
@Data
@Accessors(chain = true)
@TableName("role_jurisdiction")
public class RoleJurisdiction implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableField("sys_id")
    private String sysId;
    private String role;
    private String jurisdiction;


}
