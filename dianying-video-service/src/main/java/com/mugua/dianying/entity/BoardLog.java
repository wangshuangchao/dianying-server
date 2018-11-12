package com.mugua.dianying.entity;

import java.util.Date;
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
@TableName("board_log")
public class BoardLog implements Serializable {

    private static final long serialVersionUID = 1L;

    private String name;
    @TableField("modify_time")
    private Date modifyTime;
    @TableField("modify_man")
    private String modifyMan;


}
