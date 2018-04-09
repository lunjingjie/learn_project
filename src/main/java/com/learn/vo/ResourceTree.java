package com.learn.vo;

import java.util.ArrayList;
import java.util.List;

public class ResourceTree implements Comparable<ResourceTree>, java.io.Serializable {


    private static final long serialVersionUID = -7781760121944630641L;

    private int id;
    private String resourceName;
    private String resourcePath;
    private int pid;
    private List<ResourceTree> children = new ArrayList<ResourceTree>();

    /**
     * default constructor
     */
    public ResourceTree() {
    }

    public ResourceTree(int id, String resourceName, String resourcePath, int pid, List<ResourceTree> children) {
        super();
        this.id = id;
        this.resourceName = resourceName;
        this.resourcePath = resourcePath;
        this.pid = pid;
        this.children = children;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getPid() {
        return pid;
    }

    public void setPid(int pid) {
        this.pid = pid;
    }

    public String getResourceName() {
        return resourceName;
    }

    public void setResourceName(String resourceName) {
        this.resourceName = resourceName;
    }

    public List<ResourceTree> getChildren() {
        return children;
    }

    public void setChildren(List<ResourceTree> children) {
        this.children = children;
    }

    @Override
    public int compareTo(ResourceTree tr) {
        if (this.id > tr.id) {
            return 1;
        } else {
            return -1;
        }
    }

    public String getResourcePath() {
        return resourcePath;
    }

    public void setResourcePath(String resourcePath) {
        this.resourcePath = resourcePath;
    }
}

