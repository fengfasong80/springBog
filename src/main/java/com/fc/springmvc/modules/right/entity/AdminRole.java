package com.fc.springmvc.modules.right.entity;

    import com.baomidou.mybatisplus.annotation.TableField;
    import java.io.Serializable;

/**
* <p>
    * 
    * </p>
*
* @author jobob
* @since 2019-10-12
*/
    public class AdminRole implements Serializable {

    private static final long serialVersionUID = 1L;

            /**
            * 主键
            */
    private String id;

            /**
            * 管理员主键，外键到admin表
            */
        @TableField("adminId")
    private String adminId;

            /**
            * 角色主键，外键到role表
            */
        @TableField("roleId")
    private String roleId;

        public String getId() {
        return id;
        }

            public void setId(String id) {
        this.id = id;
        }
        public String getAdminId() {
        return adminId;
        }

            public void setAdminId(String adminId) {
        this.adminId = adminId;
        }
        public String getRoleId() {
        return roleId;
        }

            public void setRoleId(String roleId) {
        this.roleId = roleId;
        }

    @Override
    public String toString() {
    return "AdminRole{" +
            "id=" + id +
            ", adminId=" + adminId +
            ", roleId=" + roleId +
    "}";
    }
}
