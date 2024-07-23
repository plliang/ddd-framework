package com.github.plliang.domain.repository;

import com.github.plliang.domain.models.aggregate.AggregateRoot;

/**
 * 仓库抽象接口
 *
 * @author plliang
 * @version 1.0
 * @since 2024/7/22 23:37
 */
public interface RepositorySupport<T extends AggregateRoot<ID>, ID> {

    /**
     * 聚合持久化
     *
     * @param aggregate 聚合对象
     * @return 持久化后的聚合对象
     */
    public AggregateRoot<ID> create(AggregateRoot<ID> aggregate);

    public AggregateRoot<ID> update(AggregateRoot<ID> aggregate);

    public AggregateRoot<ID> findById(ID id);

    public AggregateRoot<ID> delete(ID id);

    public AggregateRoot<ID> delete(AggregateRoot<ID> aggregate);

}
