package com.learn.controller;

import com.learn.service.PageResourceService;
import com.learn.vo.ResourceTree;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("web/pageResource")
@Api(tags="页面资源信息")
public class PageResourceController {

    @Autowired
    private PageResourceService pageResourceService;

    @GetMapping
    @ApiOperation(httpMethod = "GET", value = "查询所有页面模块", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResourceTree loadAll() {
        ResourceTree resourceTree = pageResourceService.loadAllResource();
        return resourceTree;
    }

    @GetMapping("/{roleId}")
    @ApiOperation(httpMethod = "GET", value = "根据权限ID查询页面资源模块", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResourceTree loadPageReesourceByRoleId(@PathVariable Integer roleId) {
        ResourceTree resourceTree = pageResourceService.findResourceByRoleId(roleId);
        return resourceTree;
    }
}
