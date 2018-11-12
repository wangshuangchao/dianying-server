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
@TableName("user_log")
public class UserLog implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId("sys_id")
    private String sysId;
    @TableField("be_change")
    private String beChange;
    @TableField("change_man")
    private String changeMan;
    /**
     * 0:新建,1:修改
     */
    @TableField("is_new")
    private Integer isNew;
    @TableField("new_nick")
    private String newNick;
    @TableField("new_phone")
    private String newPhone;
    /**
     * 0,VIP 1,非VIP
     */
    @TableField("is_vip")
    private Integer isVip;
    @TableField("vip_time")
    private Integer vipTime;
    @TableField("new_photo")
    private String newPhoto;
    @TableField("visit_time")
    private Date visitTime;
    @TableField("visit_ip")
    private String visitIp;
    @TableField("change_time")
    private Date changeTime;
    /**
     * 0,未封禁 1,封禁
     */
    private Integer seal;
    /**
     * 0,未注销 1,注销
     */
    private Integer logout;


}
