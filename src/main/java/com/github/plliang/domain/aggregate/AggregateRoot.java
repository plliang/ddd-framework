package com.github.plliang.domain.aggregate;

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
    private String createBy;
    private String creator;
    private Date updateTime;
    private String updateBy;
    private String updater;
    private String version;

    @Override
    public ID getIdentifier() {
        return null;
    }
}