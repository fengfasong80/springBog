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
    public class RoleMenu implements Serializable {

    private static final long serialVersionUID = 1L;

            /**
            * 主键
            */
    private String id;

            /**
            * 角色主键
            */
        @TableField("roleId")
    private String roleId;

            /**
            * 菜单主键
            */
        @TableField("menuId")
    private String menuId;

        public String getId() {
        return id;
        }

            public void setId(String id) {
        this.id = id;
        }
        public String getRoleId() {
        return roleId;
        }

            public void setRoleId(String roleId) {
        this.roleId = roleId;
        }
        public String getMenuId() {
        return menuId;
        }

            public void setMenuId(String menuId) {
        this.menuId = menuId;
        }

    @Override
    public String toString() {
    return "RoleMenu{" +
            "id=" + id +
            ", roleId=" + roleId +
            ", menuId=" + menuId +
    "}";
    }
}
