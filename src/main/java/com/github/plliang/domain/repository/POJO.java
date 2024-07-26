package com.github.plliang.domain.repository;

import com.github.plliang.domain.models.entity.Entity;
import com.github.plliang.domain.models.vo.BaseUser;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

/**
 * @author plliang
 * @version 1.0
 * @since 2024/7/25 18:04
 **/
@NoArgsConstructor
@Getter
@Setter
public class POJO<E extends Entity<ID>, ID> {

    private ID id;

    private Date createTime;

    private String creatorId;
    private String creatorName;

    private Date updateTime;

    private String updaterId;
    private String updaterName;

    /**
     *
     * 与Entity对应的基础字段
     *
     * @param entity 实体
     */
    public POJO(E entity) {
        this.id = entity.getId();
        this.createTime = entity.getCreateTime();

        BaseUser creator = entity.getCreator();
        if (creator != null) {
            this.creatorId = creator.getId();
            this.creatorName = creator.getName();
        }

        BaseUser updater = entity.getUpdater();
        if (updater != null) {
            this.updaterId = updater.getId();
            this.updaterName = updater.getName();
        }

        this.updateTime = entity.getUpdateTime();
    }

    public E toEntity() {
        return null;
    }

    public void toEntity(E entity) {
        entity.setId(this.id);
        entity.setCreateTime(this.createTime);
        entity.setCreator(new BaseUser(this.creatorId, this.creatorName));
        entity.setUpdateTime(this.updateTime);
        entity.setUpdater(new BaseUser(this.updaterId, this.updaterName));
    }
}
