package com.sinsra.domain.dto;/*
 * ClassName: ChangeRoleStatusDto
 * Package: com.sinsra.domain.dto
 * @Create: 2024/5/9 15:43
 */

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ChangeRoleStatusDto {

    private Long roleId;
    private String status;
}
