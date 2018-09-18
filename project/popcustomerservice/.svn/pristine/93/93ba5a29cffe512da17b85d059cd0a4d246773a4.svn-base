package com.pop136.customerservice.utils;

import com.pop136.customerservice.vo.user.UserComm;

/**
 * Created by XH on 2018-8-17.
 */
public class UserLocal {

    private UserLocal(){}

    private static final ThreadLocal<UserComm> LOCAL = new ThreadLocal<UserComm>();

    public static void set(UserComm userComm){
        LOCAL.set(userComm);
    }

    public static UserComm get(){
        return LOCAL.get();
    }

    public static void remove(){
        LOCAL.remove();
    }
}
