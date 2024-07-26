package com.github.plliang.domain.repository;

import com.github.plliang.domain.models.entity.Entity;
import de.danielbechler.diff.node.DiffNode;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;

/**
 * @author plliang
 * @version 1.0
 * @since 2024/7/24 15:45
 **/
public abstract class DefatltRepositorySupport<T extends Entity<ID>, ID> implements RepositorySupport<T, ID>{

    /**
     * 聚合对象差异处理
     *
     * @param diffNode 差异对象
     * @param state 要处理的状态
     *
     * @return 处理结果，有差异并且处理完成了，返回1，否则返回0
     */
    protected int diffHandle(DiffNode diffNode, DiffNode.State state, Consumer<DiffNode> consumer) {

        if (diffNode != null) {
            diffNode.visitChildren((childNode, path) -> {
                if (childNode.getParentNode().equals(diffNode) && state.equals(childNode.getState())) {
                    consumer.accept(childNode);
                }
            });
        }

        return 0;
    }

    protected <L extends POJO,R> List<R> poToEntityList(List<L> poList, Function<L,R> convertor) {
        List<R> domainList = new ArrayList<>(poList.size());

        for (L t : poList) {
            domainList.add(convertor.apply(t));
        }

        return domainList;
    }
}
