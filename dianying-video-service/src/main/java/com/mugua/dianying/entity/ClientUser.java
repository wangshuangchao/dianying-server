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
@TableName("client_user")
public class ClientUser implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId("sys_id")
    private String sysId;
    private String nick;
    private String phone;
    /**
     * 0,VIP 1,非VIP
     */
    private Integer vip;
    @TableField("vip_start")
    private Date vipStart;
    @TableField("vip_time")
    private Integer vipTime;
    private String photo;
    @TableField("reg_time")
    private Date regTime;
    @TableField("reg_ip")
    private String regIp;
    @TableField("last_visit_time")
    private Date lastVisitTime;
    @TableField("last_visit_ip")
    private String lastVisitIp;
    /**
     * 0,未封禁 1,封禁
     */
    private Integer seal;
    @TableField("is_delete")
    private Integer isDelete;


}
