package com.pop136.customerservice.vo.user.search;

import java.io.Serializable;

/**
 * Created by XH on 2018-8-14.
 */
public class UserValueSearchVo  implements Serializable {

    private static final long serialVersionUID = 1L;

    private String name;//用户登录名

    private String passwd;//用户密码

    public String getPasswd() {
        return passwd;
    }

    public void setPasswd(String passwd) {
        this.passwd = passwd;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
