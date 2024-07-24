package com.github.plliang.domain.models.aggregate;

import de.danielbechler.diff.node.DiffNode;

/**
 * 拥有变更追追踪能力的聚合
 *
 * @author plliang
 * @version 1.0
 * @since 2024/7/23 22:34
 */
public interface IChangeTraceable {

    /**
     * 添加聚合追踪
     */
    public void attach();

    /**
     * 解除追踪
     */
    public void detach();

    /**
     * 聚合变更
     * @return 聚合的变更
     */
    public DiffNode diff();
}