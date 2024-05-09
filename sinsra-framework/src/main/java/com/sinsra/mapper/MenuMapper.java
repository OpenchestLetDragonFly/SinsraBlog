package com.sinsra.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.sinsra.domain.entity.Menu;
import org.apache.ibatis.annotations.Select;

import java.util.List;


/**
 * 菜单权限表(Menu)表数据库访问层
 *
 * @author makejava
 * @since 2024-05-08 14:04:42
 */
public interface MenuMapper extends BaseMapper<Menu> {

    // MenuMapper interface mapping method
    // 通过其他用户ID查询其权限
    @Select("SELECT DISTINCT m.perms FROM sys_user_role ur LEFT JOIN sys_role_menu rm ON ur.role_id = rm.role_id LEFT JOIN sys_menu m ON m.id = rm.menu_id WHERE ur.user_id = #{id} AND m.menu_type IN ('C','F') AND m.status = 0 AND m.del_flag = 0")
    List<String> selectPermsByOtherUserId(Long id);

    // 查询超级管理员的路由信息(权限菜单)
    @Select("SELECT DISTINCT m.id, m.parent_id, m.menu_name, m.path, m.component, m.visible, m.status, IFNULL(m.perms,'') AS perms, m.is_frame,  m.menu_type, m.icon, m.order_num, m.create_time FROM sys_menu m WHERE m.menu_type IN ('C','M') AND m.status = 0 AND m.del_flag = 0 ORDER BY m.parent_id,m.order_num")
    List<Menu> selectAllRouterMenu();

    // 查询普通用户的路由信息(权限菜单)
    @Select("SELECT DISTINCT m.id, m.parent_id, m.menu_name, m.path, m.component, m.visible, m.status, IFNULL(m.perms,'') AS perms, m.is_frame,  m.menu_type, m.icon, m.order_num, m.create_time FROM sys_user_role ur LEFT JOIN sys_role_menu rm ON ur.role_id = rm.role_id LEFT JOIN sys_menu m ON m.id = rm.menu_id WHERE ur.user_id = #{userId} AND m.menu_type IN ('C','M') AND m.status = 0 AND m.del_flag = 0 ORDER BY m.parent_id,m.order_num")
    List<Menu> selectOtherRouterMenuTreeByUserId(Long userId);

    //修改角色-根据角色id查询对应角色菜单列表树
    @Select("SELECT m.id FROM sys_menu m LEFT JOIN sys_role_menu rm ON m.id = rm.menu_id WHERE rm.role_id = #{roleId} ORDER BY m.parent_id, m.order_num")
    List<Long> selectMenuListByRoleId(Long roleId);
}
