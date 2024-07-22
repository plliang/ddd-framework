package com.github.plliang.domain.proxy;

import com.github.plliang.domain.aggregate.AggregateRoot;
import ma.glasnost.orika.MapperFactory;
import ma.glasnost.orika.impl.DefaultMapperFactory;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * 快照代理
 *
 * @author plliang
 * @version 1.0
 * @since 2024/7/22 23:22
 */
public class AggregateSnapshotProxy implements InvocationHandler {

    private AggregateRoot target;

    Field snapshotField = null;

    static {
        try {
            Field snapshotField = AggregateRoot.class.getDeclaredField("snapshot");
        } catch (NoSuchFieldException ignored) {

        }
    }

    public AggregateSnapshotProxy(AggregateRoot aggregateRoot) {
        this.target = aggregateRoot;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        // 对数据进行更新
        if (method.getName().startsWith("set")) {
            if (snapshotField == null) {
                Object snapshot = snapshotField.get(proxy);
                if (snapshot == null) {
                    MapperFactory mapperFactory = new DefaultMapperFactory.Builder().build();
                    snapshotField.set(proxy, mapperFactory.getMapperFacade().map(proxy, proxy.getClass()));
                }
            }
        }
        return method.invoke(proxy, args);
    }
}
