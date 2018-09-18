package com.pop136.customerservice.service.user;

import com.pop136.customerservice.mapper.agent.user.UserViewMapper;
import com.pop136.customerservice.service.AbstractBaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserViewService extends AbstractBaseService {

    @Autowired
    private UserViewMapper userMapper;

    public void init() {
        setMapper(userMapper);
    }

}
