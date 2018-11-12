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
 * 
 * </p>
 *
 * @author xiaobai123
 * @since 2018-11-05
 */
@Data
@Accessors(chain = true)
public class Slice implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId("sys_id")
    private String sysId;
    @TableField("file_url")
    private String fileUrl;
    private String url;
    private String name;
    @TableField("files_id")
    private String filesId;
    @TableField("last_modify_tie")
    private Date lastModifyTie;
    @TableField("last_mofigy_man")
    private String lastMofigyMan;
    /**
     * 0:未删除,1:已删除
     */
    @TableField("is_del")
    private Integer isDel;


}
