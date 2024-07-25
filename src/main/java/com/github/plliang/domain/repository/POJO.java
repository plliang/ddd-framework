package com.github.plliang.domain.repository;

import com.github.plliang.domain.models.aggregate.AggregateRoot;

/**
 * @author plliang
 * @version 1.0
 * @since 2024/7/25 18:04
 **/
public class POJO {

    <T extends AggregateRoot<ID>, ID> T toAggregate() {
        return null;
    }
}
