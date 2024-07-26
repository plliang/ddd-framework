package com.github.plliang.domain.repository;

import com.github.plliang.domain.models.aggregate.AggregateRoot;
import com.github.plliang.domain.models.entity.Entity;

/**
 * 仓库抽象接口
 *
 * @author plliang
 * @version 1.0
 * @since 2024/7/22 23:37
 */
public interface RepositorySupport<T extends Entity<ID>, ID> {

    /**
     * 聚合持久化
     *
     * @param entity 聚合对象
     * @return 持久化后的聚合对象
     */
    public T create(T entity);

    public T update(T entity);

    public T findById(ID id);

    public T delete(ID id);

    public T delete(T entity);
}
