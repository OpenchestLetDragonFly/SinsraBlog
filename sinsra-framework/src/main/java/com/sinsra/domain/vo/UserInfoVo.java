package com.sinsra.domain.vo;/*
 * ClassName: UserInfoVo
 * Package: com.sinsra.domain.vo
 * @Create: 2024/4/26 11:30
 */

import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
public class UserInfoVo {
    /**
     * 主键
     */
    private Long id;

    /**
     * 昵称
     */
    private String nickName;

    /**
     * 头像
     */
    private String avatar;

    private String sex;

    private String email;

}
