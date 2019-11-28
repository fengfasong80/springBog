package com.fc.springmvc.modules.right.entity;

    import java.io.Serializable;

/**
* <p>
    * 
    * </p>
*
* @author jobob
* @since 2019-10-12
*/
    public class Admin implements Serializable {

    private static final long serialVersionUID = 1L;

            /**
            * 主键
            */
    private String id;

            /**
            * 用户名
            */
    private String username;

            /**
            * 密码
            */
    private String password;

            /**
            * 真实姓名
            */
    private String realname;

        public String getId() {
        return id;
        }

            public void setId(String id) {
        this.id = id;
        }
        public String getUsername() {
        return username;
        }

            public void setUsername(String username) {
        this.username = username;
        }
        public String getPassword() {
        return password;
        }

            public void setPassword(String password) {
        this.password = password;
        }
        public String getRealname() {
        return realname;
        }

            public void setRealname(String realname) {
        this.realname = realname;
        }

    @Override
    public String toString() {
    return "Admin{" +
            "id=" + id +
            ", username=" + username +
            ", password=" + password +
            ", realname=" + realname +
    "}";
    }
}
