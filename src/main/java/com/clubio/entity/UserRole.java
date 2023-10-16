package com.clubio.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.v3.oas.annotations.media.Schema;

import java.io.Serializable;

/**
 * <p>
 * 用户角色关联表
 * </p>
 *
 * @author Smile
 * @since 2023-10-15
 */
@TableName("user_role")
@Schema(description = "用户角色关联表")
public class UserRole implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableField(value = "user_id")
    private Long userId;

    @TableField(value = "role_id")
    private Integer roleId;

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Integer getRoleId() {
        return roleId;
    }

    public void setRoleId(Integer roleId) {
        this.roleId = roleId;
    }

    @Override
    public String toString() {
        return "UserRole{" +
                "userId = " + userId +
                ", roleId = " + roleId +
                "}";
    }
}
