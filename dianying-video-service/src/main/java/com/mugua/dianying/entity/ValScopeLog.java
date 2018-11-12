package com.mugua.dianying.entity;

import java.util.Date;
import com.baomidou.mybatisplus.annotations.TableId;
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
@TableName("val_scope_log")
public class ValScopeLog implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId("sys_id")
    private String sysId;
    @TableField("extend_type")
    private String extendType;
    @TableField("extend_val")
    private String extendVal;
    @TableField("change_time")
    private Date changeTime;
    @TableField("change_man")
    private String changeMan;


}
