package com.github.plliang.domain.models.entity;

import com.github.plliang.domain.vo.Identified;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * 领域实体
 *
 * @author plliang
 * @since 2024-07-22 22:47:22
 * @param <ID> id类型
 */
@Setter
@Getter
@NoArgsConstructor
public abstract class Entity<ID> implements Identified<ID> {

    private ID id;

    @Override
    public ID getIdentifier() {
        return null;
    }

    public Entity(ID id) {
        this.id = id;
    }
}
