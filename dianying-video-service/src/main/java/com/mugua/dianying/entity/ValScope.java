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
@TableName("val_scope")
public class ValScope implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId("sys_id")
    private String sysId;
    @TableField("extend_type")
    private String extendType;
    @TableField("extend_val")
    private String extendVal;
    @TableField("create_time")
    private Date createTime;
    @TableField("create_man")
    private String createMan;
    @TableField("modify_time")
    private Date modifyTime;
    @TableField("modify_man")
    private String modifyMan;
    @TableField("is_delete")
    private int  isDelete;


}
