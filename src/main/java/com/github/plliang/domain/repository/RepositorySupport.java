package com.github.plliang.domain.repository;

import com.github.plliang.domain.aggregate.AggregateRoot;

import java.lang.reflect.Proxy;

/**
 * @author plliang
 * @version 1.0
 * @since 2024/7/22 23:37
 */
public class RepositorySupport<T extends AggregateRoot> {

    public T proxy(T aggregate) {
        Proxy.newProxyInstance(this.getClass().getClassLoader(), new Class[AggregateRoot.class], )
    }
}
