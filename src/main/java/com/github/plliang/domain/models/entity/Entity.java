package com.github.plliang.domain.models.entity;

import com.github.plliang.domain.models.vo.BaseUser;
import com.github.plliang.domain.vo.Identified;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

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
    private Date createTime;
    private BaseUser creator;
    private Date updateTime;
    private BaseUser updater;
    private long lockVersion;

    @Override
    public ID identifier() {
        return id;
    }

    /**
     * 初始化
     * @param creator 创建者
     */
    public void init(BaseUser creator) {
        this.id = idGenerator();
        this.createTime = new Date();
        this.creator = creator;
        update(creator);
        this.lockVersion = 1;
    }

    /**
     * 聚合更新
     * @param updater 更新人
     */
    public void update(BaseUser updater) {
        this.updater = updater;
        this.updateTime = new Date();
        this.lockVersion++;
    }

    /**
     * ID生成器，有些数据是数据库自增ID，所以就不需要实现此方法
     *
     * @return ID
     */
    public ID idGenerator() {
        return null;
    }

    public Entity(Entity<ID> entity) {
        this.id = entity.getId();
        this.createTime = entity.createTime;
        this.creator = entity.creator;
        this.updateTime = entity.updateTime;
        this.updater = entity.updater;
        this.lockVersion = entity.lockVersion;
    }

    public Entity(ID id) {
        this.id = id;
    }

}
