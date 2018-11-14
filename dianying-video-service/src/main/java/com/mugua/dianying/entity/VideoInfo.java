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
 * 客户端展示的视频信息及用到的视频信息
 * </p>
 *
 * @author xiaobai123
 * @since 2018-11-14
 */
@Data
@Accessors(chain = true)
@TableName("video_info")
public class VideoInfo implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId("sys_id")
    private String sysId;
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
    private Integer counts;
    @TableField("last_modify_time")
    private Date lastModifyTime;
    @TableField("last_modify_man")
    private String lastModifyMan;
    @TableField("is_delete")
    private Integer isDelete;


}
