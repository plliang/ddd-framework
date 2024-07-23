package com.github.plliang.domain.models.aggregate;

import com.github.plliang.domain.models.vo.BaseUser;
import com.github.plliang.domain.vo.Identified;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

/**
 * 聚合标识
 * <a href='https://www.cnblogs.com/davenkin/p/ddd-aggregate-and-repository.html'>
 */
@Getter
@Setter
@NoArgsConstructor
public class AggregateRoot<ID> implements Identified<ID> {

    private AggregateRoot<ID> snapshot = null;

    private ID id;
    private Date createTime;
    private BaseUser creator;
    private Date updateTime;
    private BaseUser updater;
    private int version;

    @Override
    public ID getIdentifier() {
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
    }

    /**
     * 聚合更新
     * @param updater 更新人
     */
    public void update(BaseUser updater) {
        this.updater = updater;
        this.updateTime = new Date();
    }

    /**
     * ID生成器，有些数据是数据库自增ID，所以就不需要实现此方法
     *
     * @return ID
     */
    public ID idGenerator() {
        return null;
    }
}