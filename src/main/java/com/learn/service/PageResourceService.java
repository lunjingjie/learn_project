package com.learn.service;

import com.learn.vo.ResourceTree;

public interface PageResourceService {

    /**
     * @param roleId
     * @return
     */
    ResourceTree findResourceByRoleId(Integer roleId);

    /**
     * 加载所有资源树
     * @return
     */
    ResourceTree loadAllResource();
}
