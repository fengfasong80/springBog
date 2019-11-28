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
    public class Role implements Serializable {

    private static final long serialVersionUID = 1L;

            /**
            * 角色主键
            */
    private String id;

            /**
            * 角色名称
            */
    private String name;

            /**
            * 角色代码
            */
    private String code;

        public String getId() {
        return id;
        }

            public void setId(String id) {
        this.id = id;
        }
        public String getName() {
        return name;
        }

            public void setName(String name) {
        this.name = name;
        }
        public String getCode() {
        return code;
        }

            public void setCode(String code) {
        this.code = code;
        }

    @Override
    public String toString() {
    return "Role{" +
            "id=" + id +
            ", name=" + name +
            ", code=" + code +
    "}";
    }
}
