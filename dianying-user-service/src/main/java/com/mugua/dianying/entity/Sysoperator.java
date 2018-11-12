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
public class Sysoperator implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId("sys_id")
    private String sysId;
    /**
     * 显示用的名字
            
     */
    private String nick;
    /**
     * 程序中用的名字
     */
    private String name;
    private String pwd;
    /**
     * 拥有创建操作员的权限
            
     */
    @TableField("create_man")
    private String createMan;
    /**
     * 操作员被创建的时间
     */
    @TableField("create_time")
    private Date createTime;
    /**
     * 操作员拥有的角色,角色中有权限
     */
    private String role1;
    private String role2;
    /**
     * 创建人或修改人写的备注
            
     */
    private String remark;
    /**
     * 0:删除,1:未删除
            
     */
    @TableField("is_del")
    private Integer isDel;
    @TableField("last_modify_time")
    private Date lastModifyTime;
    @TableField("last_modify_man")
    private byte[] lastModifyMan;


}
