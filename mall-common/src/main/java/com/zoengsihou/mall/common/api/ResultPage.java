package com.zoengsihou.mall.common.api;

import com.github.pagehelper.PageInfo;

import java.util.List;

/**
 * 封装分页数据
 * @author zoengsihou
 */

public class ResultPage<T> {
    private Integer pageNum;
    private Integer pageSize;
    private Integer totalPage;
    private Long total;
    private List<T> list;

    /**
     * 提取PageHelper分页返回的page类(list子类)信息，封装为ResultPage
     */
    public static <T> ResultPage<T> createPage(List<T> list) {
        ResultPage<T> result = new ResultPage<T>();
        PageInfo<T> pageInfo = new PageInfo<T>(list);
        result.setList(pageInfo.getList());
        result.setPageNum(pageInfo.getPageNum());
        result.setPageSize(pageInfo.getPageSize());
        result.setTotal(pageInfo.getTotal());
        result.setTotalPage(pageInfo.getPages());
        return result;
    }

    public Integer getPageNum() {
        return pageNum;
    }

    public void setPageNum(Integer pageNum) {
        this.pageNum = pageNum;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public Integer getTotalPage() {
        return totalPage;
    }

    public void setTotalPage(Integer totalPage) {
        this.totalPage = totalPage;
    }

    public Long getTotal() {
        return total;
    }

    public void setTotal(Long total) {
        this.total = total;
    }

    public List<T> getList() {
        return list;
    }

    public void setList(List<T> list) {
        this.list = list;
    }
}
