package com.hujesse.onlineSchool.entity;

import com.baomidou.mybatisplus.annotation.*;
import lombok.Builder;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
@TableName(value = "user")
@Builder
public class User implements Serializable {
    private static final long serialVersionUID = -7853088485140370687L;
    @TableId(type = IdType.AUTO)
    private Long id;
    private String name;
    private Integer age;
    private String email;
    @TableField(fill = FieldFill.INSERT)
    private Date createTime;
    @TableField(fill = FieldFill.INSERT_UPDATE)
    private Date updateTime;
    @TableLogic
    private Integer deleted;

    @Version
    private Integer version;

}
