package com.mugua.dianying.entity;

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
@TableName("video_info_board")
public class VideoInfoBoard implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId("sys_id")
    private String sysId;
    @TableField("video_info")
    private String videoInfo;
    private String board;


}
