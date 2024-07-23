package com.github.plliang.domain.models.aggregate;

import de.danielbechler.diff.ObjectDifferBuilder;
import de.danielbechler.diff.node.DiffNode;
import ma.glasnost.orika.MapperFactory;
import ma.glasnost.orika.impl.DefaultMapperFactory;

/**
 * @author plliang
 * @version 1.0
 * @since 2024/7/23 22:43
 */
public class ChangeTraceableAggregate implements IChangeTraceableAggregate<AggregateRoot> {

    private AggregateRoot snapshot = null;

    @Override
    public void attach(AggregateRoot aggregate) {
        MapperFactory mapperFactory = new DefaultMapperFactory.Builder().build();
        snapshot = mapperFactory.getMapperFacade().map(aggregate, aggregate.getClass());
    }

    @Override
    public void detach(AggregateRoot aggregate) {
        snapshot = null;
    }

    @Override
    public DiffNode diff(AggregateRoot aggregate) {
        if (snapshot == null) {
            return null;
        }
        return ObjectDifferBuilder.buildDefault().compare(aggregate, snapshot);
    }
}
