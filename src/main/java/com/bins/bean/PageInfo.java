package com.bins.bean;

import java.util.List;

public class PageInfo {
    private int currentPage;
    private int totalPage;
    private int totalCount;
    private List<User> list;
    private int size;//每页数据量

    public int getCurrentPage() {
        return currentPage;
    }

    public int getTotalPage() {
        return totalPage;
    }

    public int getTotalCount() {
        return totalCount;
    }

    public List<User> getList() {
        return list;
    }

    public int getSize() {
        return size;
    }

    public void setCurrentPage(int currentPage) {
        this.currentPage = currentPage;
    }

    public void setTotalPage(int totalPage) {
        this.totalPage = totalPage;
    }

    public void setTotalCount(int totalCount) {
        this.totalCount = totalCount;
    }

    public void setList(List<User> list) {
        this.list = list;
    }

    public void setSize(int size) {
        this.size = size;
    }

    @Override
    public String toString() {
        return "PageInfo{" +
                "currentPage=" + currentPage +
                ", totalPage=" + totalPage +
                ", totalCount=" + totalCount +
                ", list=" + list +
                ", size=" + size +
                '}';
    }
}
