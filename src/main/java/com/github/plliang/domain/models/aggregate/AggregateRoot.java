package com.github.plliang.domain.models.aggregate;

import com.github.plliang.domain.models.entity.Entity;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * 聚合标识
 * <a href='https://www.cnblogs.com/davenkin/p/ddd-aggregate-and-repository.html'>
 */
@Getter
@Setter
@NoArgsConstructor
public class AggregateRoot<ID> extends Entity<ID> {

}