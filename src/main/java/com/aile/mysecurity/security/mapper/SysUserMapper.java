package com.aile.mysecurity.security.mapper;

import com.aile.mysecurity.security.entity.SysUser;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author aile
 * @since 2019-12-13
 */
public interface SysUserMapper extends BaseMapper<SysUser> {

    SysUser selectByName(String username);

}
