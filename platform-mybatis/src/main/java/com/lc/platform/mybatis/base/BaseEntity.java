package com.lc.platform.mybatis.base;

import java.util.Date;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableLogic;
import com.baomidou.mybatisplus.annotation.Version;

import lombok.Data;
@Data
public class BaseEntity {
	@TableId(value = "id", type = IdType.AUTO)
    protected Integer id;

    @TableField("sys_version")
    @Version
    protected Integer sysVersion;

    @TableField("delete_flag")
    @TableLogic
    protected Integer deleteFlag;

    @TableField(value = "create_date", fill = FieldFill.INSERT)
    protected Date createDate;

    @TableField(value = "create_user", fill = FieldFill.INSERT)
    protected Integer createUser;

    @TableField(value = "update_date", fill = FieldFill.INSERT_UPDATE)
    protected Date updateDate;

    @TableField(value = "update_user", fill = FieldFill.INSERT_UPDATE)
    protected Integer updateUser;

    @TableField("remark")
    protected String remark;
}
