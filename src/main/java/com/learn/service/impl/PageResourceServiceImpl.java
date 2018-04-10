package com.learn.service.impl;

import com.learn.dao.PageResourceDao;
import com.learn.service.PageResourceService;
import com.learn.vo.ResourceTree;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PageResourceServiceImpl implements PageResourceService {

    @Autowired
    private PageResourceDao pageResourceDao;

    /**
     * @param roleId
     * @return
     */
    @Override
    public ResourceTree findResourceByRoleId(Integer roleId) {
        ResourceTree resourceTree = createResourceTree(roleId, 1);
        return resourceTree;
    }

    public ResourceTree createResourceTree(Integer roleId, Integer cId) {
        ResourceTree node = pageResourceDao.getParentNode(roleId, cId);
        List<ResourceTree> childs = pageResourceDao.getChildNode(roleId, cId);
        for(ResourceTree tree : childs) {
            ResourceTree n = createResourceTree(roleId, tree.getId());
            node.getChildren().add(n);
        }
        return node;
    }

    /**
     * 加载所有资源树
     *
     * @return
     */
    @Override
    public ResourceTree loadAllResource() {
        ResourceTree resourceTree = createResourceTree(1);
        return resourceTree;
    }

    public ResourceTree createResourceTree(int cId) {
        ResourceTree node = pageResourceDao.getParentNode(cId);
        List<ResourceTree> childrenTreeNodes = pageResourceDao.getChildNode(cId);
        for (ResourceTree resourceTree : childrenTreeNodes) {
            ResourceTree n = createResourceTree(resourceTree.getId());
            node.getChildren().add(n);
        }
        return node;
    }
}
