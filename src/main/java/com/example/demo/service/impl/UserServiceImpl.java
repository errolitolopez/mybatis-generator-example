package com.example.demo.service.impl;

import com.example.demo.dao.TUser;
import com.example.demo.dao.TUserExample;
import com.example.demo.dao.TUserMapper;
import com.example.demo.service.UserService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

import static org.springframework.transaction.annotation.Propagation.REQUIRED;

@Service
public class UserServiceImpl implements UserService {

    @Resource
    private TUserMapper userMapper;

    @Override
    @Transactional(propagation = REQUIRED)
    public void save(String name) {
        TUserExample example = new TUserExample();
        example.createCriteria().andNameEqualTo(name);
        List<TUser> users = userMapper.selectByExample(example);
        if (users.isEmpty()) {
            TUser user = new TUser();
            user.setName(name);
            userMapper.insertSelective(user);
        } else {
            System.out.println("name is existing:" + name);
        }
    }

    @Override
    public List<TUser> list() {
        return userMapper.selectByExample(new TUserExample());
    }
}
