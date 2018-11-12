package com.mugua.dianying.entity;

import java.util.Date;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableField;
import java.io.Serializable;

import com.baomidou.mybatisplus.annotations.Version;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 某个视频隶属的版块(例如:电影,电视剧,动漫)
 * </p>
 *
 * @author xiaobai123
 * @since 2018-11-05
 */
@Data
@Accessors(chain = true)
public class Board implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId("sys_id")
    private String sysId;
    private String name;
    @TableField("create_time")
    private Date createTime;
    @TableField("create_man")
    private String createMan;
    @TableField("modify_time")
    private Date modifyTime;
    @TableField("modify_man")
    private String modifyMan;


}
