package com.learn.dao;

import com.learn.vo.ResourceTree;

import java.util.List;

public interface PageResourceDao {

    /**
     * 根据roleId与节点Id加载父node
     * @param roleId
     * @param cId
     * @return
     */
    ResourceTree getParentNode(Integer roleId, Integer cId);

    /**
     * 根据roleId与父节点Id加载子node
     * @param roleId
     * @param cId
     * @return
     */
    List<ResourceTree> getChildNode(Integer roleId, Integer cId);

    /**
     * 根据节点Id加载父node
     * @param cId
     * @return
     */
    ResourceTree getParentNode(Integer cId);

    /**
     * 根据父节点Id加载子node
     * @param pId
     * @return
     */
    List<ResourceTree> getChildNode(Integer pId);
}
