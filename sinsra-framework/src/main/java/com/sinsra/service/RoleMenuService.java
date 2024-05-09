package com.sinsra.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.sinsra.domain.entity.RoleMenu;


/**
 * 角色和菜单关联表(SysRoleMenu)表服务接口
 *
 * @author makejava
 * @since 2024-05-09 15:46:41
 */
public interface RoleMenuService extends IService<RoleMenu> {

    //修改角色-保存修改好的角色信息
    void deleteRoleMenuByRoleId(Long id);

}
