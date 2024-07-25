package com.github.plliang.domain.models.aggregate;

import de.danielbechler.diff.ObjectDifferBuilder;
import de.danielbechler.diff.node.DiffNode;
import lombok.Getter;
import ma.glasnost.orika.MapperFactory;
import ma.glasnost.orika.impl.DefaultMapperFactory;

/**
 * 拥有变更追踪能力的聚合根
 *
 * @author plliang
 * @version 1.0
 * @since 2024/7/23 22:43
 */
@Getter
public class ChangeTraceableAggregate<ID> extends AggregateRoot<ID> implements IChangeTraceable {

    private AggregateRoot<ID> snapshot = null;

    @Override
    public void attach() {
        MapperFactory mapperFactory = new DefaultMapperFactory.Builder().build();
        snapshot = mapperFactory.getMapperFacade().map(this, this.getClass());
    }

    @Override
    public void detach() {
        snapshot = null;
    }

    @Override
    public DiffNode diff() {
        if (snapshot == null) {
            return null;
        }
        return ObjectDifferBuilder.buildDefault().compare(this, snapshot);
    }
}
