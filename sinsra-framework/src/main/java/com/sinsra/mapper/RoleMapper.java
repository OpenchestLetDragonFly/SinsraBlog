package com.sinsra.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.sinsra.domain.entity.Role;
import org.apache.ibatis.annotations.Select;

import java.util.List;


/**
 * 角色信息表(Role)表数据库访问层
 *
 * @author makejava
 * @since 2024-05-08 13:53:49
 */
public interface RoleMapper extends BaseMapper<Role> {

    @Select("SELECT r.role_key FROM sys_user_role ur LEFT JOIN sys_role r ON ur.role_id = r.id WHERE ur.user_id = #{userId} AND r.status = 0 AND r.del_flag = 0")
    List<String> selectRoleKeyByOtherUserId(Long userId);


    //修改用户-①根据id查询用户信息
    @Select("SELECT r.id FROM sys_role r LEFT JOIN sys_user_role ur ON ur.role_id = r.id WHERE ur.user_id = #{userId}")
    List<Long> selectRoleIdByUserId(Long userId);

}
