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
@TableName("extend_type_log")
public class ExtendTypeLog implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId("sys_id")
    private String sysId;
    private String name;
    /**
     * 0,单选 1,多选 2,数值 3,字符串
     */
    @TableField("extend_type")
    private Integer extendType;
    @TableField("extend_default")
    private String extendDefault;
    @TableField("change_time")
    private Date changeTime;
    @TableField("change_man")
    private String changeMan;


}
