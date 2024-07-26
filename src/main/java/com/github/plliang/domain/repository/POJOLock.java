package com.github.plliang.domain.repository;

import com.github.plliang.domain.models.entity.Entity;
import lombok.Getter;
import lombok.Setter;

/**
 * @author plliang
 * @version 1.0
 * @since 2024/7/26 17:02
 **/
@Getter
@Setter
public class POJOLock<E extends Entity<ID>, ID> extends POJO<E, ID> {

    private long lockVersion;

    public POJOLock(E entity) {
        super(entity);
        this.lockVersion = entity.getLockVersion();
    }

    @Override
    public void toEntity(E entity) {
        super.toEntity(entity);
        entity.setLockVersion(this.lockVersion);
    }
}
