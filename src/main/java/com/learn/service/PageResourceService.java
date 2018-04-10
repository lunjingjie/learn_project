package com.learn.service;

import com.learn.vo.ResourceTree;

/**
 * @author lunjingjie
 */
public interface PageResourceService {

    /**
     * 通过roleId查找页面资源
     * @param roleId 权限ID
     * @return ResourceTree
     */
    ResourceTree findResourceByRoleId(Integer roleId);

    /**
     * 加载所有资源树
     * @return ResourceTree
     */
    ResourceTree loadAllResource();
}
