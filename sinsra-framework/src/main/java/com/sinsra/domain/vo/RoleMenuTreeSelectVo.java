package com.sinsra.domain.vo;/*
 * ClassName: RoleMenuTreeSelectVo
 * Package: com.sinsra.domain.vo
 * @Create: 2024/5/9 16:33
 */

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.util.List;

@Data
@Accessors(chain = true)
@AllArgsConstructor
@NoArgsConstructor
public class RoleMenuTreeSelectVo {

    private List<Long> checkedKeys;

    private List<MenuTreeVo> menus;
}
