package com.sinsra.vo;/*
 * ClassName: PageVO
 * Package: com.sinsra.vo
 * @Create: 2024/4/24 20:58
 */

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PageVO {
    List rows;
    Long total;
}
