package com.sinsra.domain.vo;/*
 * ClassName: UserInfoAndRoleIdsVo
 * Package: com.sinsra.domain.vo
 * @Create: 2024/5/9 17:08
 */

import com.sinsra.domain.entity.Role;
import com.sinsra.domain.entity.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserInfoAndRoleIdsVo {
    private User user;
    private List<Role> roles;
    private List<Long> roleIds;
}
