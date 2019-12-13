package com.aile.mysecurity.security.service.impl;

import com.aile.mysecurity.security.entity.SysRole;
import com.aile.mysecurity.security.entity.SysUser;
import com.aile.mysecurity.security.mapper.SysUserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.util.DigestUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author aile
 * @since 2019-12-13
 */
@Service
public class SysUserServiceImpl implements UserDetailsService {



    @Autowired
    private SysUserMapper userMapper;

    @Override
    public UserDetails loadUserByUsername(String username) { //重写loadUserByUsername 方法获得 userdetails 类型用户

        System.out.println(username);
        SysUser user = userMapper.selectByName(username);
        if(user == null){
            throw new UsernameNotFoundException("用户名不存在");
        }
        List<SimpleGrantedAuthority> authorities = new ArrayList<>();
        //用于添加用户的权限。只要把用户权限添加到authorities 就万事大吉。
        for(SysRole role:user.getRole())
        {
            authorities.add(new SimpleGrantedAuthority(role.getName()));
//            System.out.println(role.getName());
        }
        return new User(user.getUsername(),
                user.getPassword(), authorities);
    }
}
