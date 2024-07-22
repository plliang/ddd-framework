package com.github.plliang.domain.vo;

/**
 * ID标识值对象
 *
 * @author plliang
 * @version 1.0
 * @since 2024/7/22 22:55
 */
public interface Identified<ID> {

    /**
     * 获取ID
     *
     * @return 返回ID
     */
    public ID getIdentifier();
}
