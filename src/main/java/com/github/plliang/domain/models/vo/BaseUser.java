package com.github.plliang.domain.models.vo;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * 基础人员值对象
 *
 * @author plliang
 * @version 1.0
 * @since 2024/7/23 23:15
 */
@Setter
@Getter
@NoArgsConstructor
public class BaseUser {

    private String id;

    private String name;
}
