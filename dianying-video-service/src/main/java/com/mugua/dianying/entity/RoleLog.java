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
@TableName("role_log")
public class RoleLog implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId("sys_id")
    private String sysId;
    @TableField("be_change")
    private String beChange;
    @TableField("change_man")
    private String changeMan;
    /**
     * 0:新建,1:修改
     */
    @TableField("is_new")
    private Integer isNew;
    @TableField("new_name")
    private String newName;
    @TableField("add_jurisdiction")
    private String addJurisdiction;
    @TableField("red_juris")
    private String redJuris;
    @TableField("change_time")
    private Date changeTime;


}
