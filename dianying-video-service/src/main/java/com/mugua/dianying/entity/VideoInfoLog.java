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
@TableName("video_info_log")
public class VideoInfoLog implements Serializable {

    private static final long serialVersionUID = 1L;

    private Integer amounts;
    private Integer witchone;
    private String picture;
    /**
     * 0:免费 1:VIP
     */
    private Integer cost;
    /**
     * 0:未上架 1:已上架 2:已下架
     */
    private Integer putaway;
    /**
     * 0:未检测 1:检测未通过 2:检测通过
     */
    private Integer test;
    @TableField("test_man")
    private String testMan;
    @TableField("test_time")
    private Date testTime;
    /**
     * 0:站内 1:站外
     */
    @TableField("video_from")
    private Integer videoFrom;
    private String url;
    @TableField("change_time")
    private Date changeTime;
    @TableField("change_man")
    private String changeMan;
    private String board;


}
