package com.aile.mysecurity.security.auth;

import com.aile.mysecurity.security.entity.SysUser;
import com.aile.mysecurity.security.mapper.SysUserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.util.DigestUtils;

/**
 * @Author aile
 * @Date 2019/12/13 15:32
 */
public class MyAuthenticationProvider implements AuthenticationProvider {

    @Autowired
    private SysUserMapper userMapper;

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        String username = authentication.getName();
        String password = authentication.getCredentials().toString();
        SysUser user = userMapper.selectByName(username);
        if (user == null){
            throw new UsernameNotFoundException("用户名不存在");
        }
        if (!user.getPassword().equals(DigestUtils.md5DigestAsHex(user.getPassword().getBytes()))){
            throw new BadCredentialsException("用户凭证错误");
        }
        // 验证码是否正确 测试写死123456
//        if(verifyCode.equals("123456")){
//            UserDetails userDetails = userService.loadUserByUsername(name);
//            //验证用户名
//            if(userDetails == null||userDetails.getUsername() == null){
//                throw new UsernameNotFoundException("用户名未找到");
//            }
//            //验证用户密码
//            if(userDetails.getPassword().equals(DigestUtils.md5DigestAsHex(password.getBytes()))){
//                //如果账户被禁用
//                if(!userDetails.isEnabled()){
//                    throw new DisabledException("用户被禁用");
//                }
//                return new UsernamePasswordAuthenticationToken(name, null, userDetails.getAuthorities());
//            }
//            //用户密码错误
//            throw new BadCredentialsException("用户凭证错误");
//        }else {
//            throw new VerifyCodeException("验证码错误");
//        }
            return null;
    }

    @Override
    public boolean supports(Class<?> aClass) {
        return true;
    }
}
