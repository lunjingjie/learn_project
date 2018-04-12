package com.learn.service.impl;

import com.learn.dao.PageResourceDao;
import com.learn.service.PageResourceService;
import com.learn.vo.ResourceTree;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author lunjingjie
 */
@Service
public class PageResourceServiceImpl implements PageResourceService {

    private final PageResourceDao pageResourceDao;

    @Autowired
    public PageResourceServiceImpl(PageResourceDao pageResourceDao) {
        this.pageResourceDao = pageResourceDao;
    }

    /**
     * @param roleId 权限Id
     * @return ResourceTree
     */
    @Override
    public ResourceTree findResourceByRoleId(Integer roleId) {
        return createResourceTree(roleId, 1);
    }

    private ResourceTree createResourceTree(Integer roleId, Integer cId) {
        ResourceTree node = pageResourceDao.getParentNode(roleId, cId);
        List<ResourceTree> childs = pageResourceDao.getChildNode(roleId, cId);
        for (ResourceTree tree : childs) {
            ResourceTree n = createResourceTree(roleId, tree.getId());
            node.getChildren().add(n);
        }
        return node;
    }

    /**
     * 加载所有资源树
     *
     * @return ResourceTree
     */
    @Override
    public ResourceTree loadAllResource() {
        return createResourceTree(1);
    }

    private ResourceTree createResourceTree(int cId) {
        ResourceTree node = pageResourceDao.getParentNode(cId);
        List<ResourceTree> childrenTreeNodes = pageResourceDao.getChildNode(cId);
        for (ResourceTree resourceTree : childrenTreeNodes) {
            ResourceTree n = createResourceTree(resourceTree.getId());
            node.getChildren().add(n);
        }
        return node;
    }
}
