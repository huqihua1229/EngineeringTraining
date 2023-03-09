package com.hqh.dto;

public class Pager {
    Integer page;
    Integer recTotal;
    Integer recPerPage;

    public Integer getPage() {
        return page;
    }

    public void setPage(Integer page) {
        this.page = page;
    }

    public Integer getRecTotal() {
        return recTotal;
    }

    public void setRecTotal(Integer recTotal) {
        this.recTotal = recTotal;
    }

    public Integer getRecPerPage() {
        return recPerPage;
    }

    public void setRecPerPage(Integer recPerPage) {
        this.recPerPage = recPerPage;
    }

    @Override
    public String toString() {
        return "Pager{" +
                "page=" + page +
                ", recTotal=" + recTotal +
                ", recPerPage=" + recPerPage +
                '}';
    }
}
