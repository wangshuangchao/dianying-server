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
 * @since 2018-11-05
 */
@Data
@Accessors(chain = true)
@TableName("video_file")
public class VideoFile implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId("sys_id")
    private String sysId;
    private String headline;
    @TableField("file_url")
    private String fileUrl;
    private String upman;
    private Date uptime;
    /**
     * 0,没有切片 1,已切片
     */
    @TableField("is_slices")
    private Integer isSlices;
    /**
     * 什么时候进行的切片
     */
    @TableField("slices_time")
    private Date slicesTime;
    @TableField("slices_man")
    private String slicesMan;
    /**
     * 0,未上传 1,已上传
     */
    private Integer onfastdfs;
    private String upfastdfsman;
    /**
     * 什么时候上传到文件服务器的
     */
    private Date upfastdfstime;
    /**
     * 上传到文件服务器,返回的m3u8的地址
            
     */
    private String url;
    private String directory;
    /**
     * 0,未被引用 1,已被引用
            被视频信息的播放地址使用就是被引用
     */
    private Integer iscite;
    @TableField("last_modify_time")
    private Date lastModifyTime;
    @TableField("last_modify_man")
    private String lastModifyMan;


}
