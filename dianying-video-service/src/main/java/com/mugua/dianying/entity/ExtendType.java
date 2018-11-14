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
 * @since 2018-11-14
 */
@Data
@Accessors(chain = true)
@TableName("extend_type")
public class ExtendType implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId("sys_id")
    private String sysId;
    private String name;
    /**
     * 0,单选 1,多选 2,数值 3,字符串
     */
    @TableField("type_val")
    private Integer extendType;
    @TableField("default_val")
    private String extendDefault;
    @TableField("create_time")
    private Date createTime;
    @TableField("create_man")
    private String createMan;
    @TableField("modify_time")
    private Date modifyTime;
    @TableField("modify_man")
    private String modifyMan;
    @TableField("is_delete")
    private int isDelete;


}
