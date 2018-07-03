package com.migen.iotcloud.dto;

import javax.persistence.criteria.CriteriaBuilder;

public class Tree {
    private int id;// 表id
    private Integer pid;// 父节点id
    private String text;// 节点内容
    private String attributes;// 请求路径
    private String state;// 节点内容
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public Integer getPid() {
        return pid;
    }
    public void setPid(Integer pid) {
        this.pid = pid;
    }
    public String getText() {
        return text;
    }
    public void setText(String text) {
        this.text = text;
    }
    public String getAttributes() {
        return attributes;
    }
    public void setAttributes(String attributes) {
        this.attributes = attributes;
    }
    public String getState() {
        return state;
    }
    public void setState(String state) {
        this.state = state;
    }

}