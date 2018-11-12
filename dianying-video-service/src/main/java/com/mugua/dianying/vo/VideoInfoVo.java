package com.mugua.dianying.vo;

import java.util.Date;

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.mugua.dianying.entity.Board;
import com.mugua.dianying.entity.ExtendType;
import com.mugua.dianying.entity.ExtendTypeVal;
import com.mugua.dianying.entity.ValScope;
import com.mugua.dianying.entity.VideoInfo;
import com.mugua.dianying.entity.VideoInfoBoard;
import com.mugua.dianying.service.BoardService;
import com.mugua.dianying.service.ExtendTypeService;
import com.mugua.dianying.service.ExtendTypeValService;
import com.mugua.dianying.service.VideoInfoService;

import lombok.Data;

/**
 *  返回给前端的数据
 * @author 28695
 *
 */
@Data
public class VideoInfoVo {
	private static final long serialVersionUID = 1L;
	//查询数据用
	//video_info
	private String videoInfoSysId;
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
    
    //board
    private String boardSysId;
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
