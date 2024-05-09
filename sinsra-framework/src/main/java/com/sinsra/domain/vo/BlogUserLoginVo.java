package com.sinsra.domain.vo;/*
 * ClassName: BlogUserVo
 * Package: com.sinsra.domain.vo
 * @Create: 2024/4/26 11:33
 */

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class BlogUserLoginVo {

    private String token;
    private UserInfoVo userInfo;
}
