package com.sinsra.domain.vo;/*
 * ClassName: RoutersVo
 * Package: com.sinsra.domain.vo
 * @Create: 2024/5/8 17:43
 */

import com.sinsra.domain.entity.Menu;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RoutersVo {
    private List<Menu> menus;
}
