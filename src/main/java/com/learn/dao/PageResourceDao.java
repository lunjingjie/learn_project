package com.learn.dao;

import com.learn.vo.ResourceTree;

import java.util.List;

/**
 * @author lunjingjie
 */
public interface PageResourceDao {

    /**
     * 根据roleId与节点Id加载父node
     * @param roleId 权限Id
     * @param cId 用于查找子元素的id
     * @return ResourceTree
     */
    ResourceTree getParentNode(Integer roleId, Integer cId);

    /**
     * 根据roleId与父节点Id加载子node
     * @param roleId 权限Id
     * @param cId 用于查找子元素的id
     * @return List
     */
    List<ResourceTree> getChildNode(Integer roleId, Integer cId);

    /**
     * 根据节点Id加载父node
     * @param cId 用于查找子元素的id
     * @return ResourceTree
     */
    ResourceTree getParentNode(Integer cId);

    /**
     * 根据父节点Id加载子node
     * @param pId pid
     * @return List
     */
    List<ResourceTree> getChildNode(Integer pId);
}
