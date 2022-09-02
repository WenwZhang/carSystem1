package com.jkxy.car.api.pojo;

public class CarInfo {

    private String carName;
    private Long pageNum;
    private Long pageSize;

    public Long getPageNum() {
        return pageNum;
    }

    public void setPageNum(Long pageNum) {
        this.pageNum = pageNum;
    }

    public Long getPageSize() {
        return pageSize;
    }

    public void setPageSize(Long pageSize) {
        this.pageSize = pageSize;
    }

    public String getCarName() {
        return carName;
    }

    public void setCarName(String carName) {
        this.carName = carName;
    }

    @Override
    public String toString() {
        return "CarInfo{" +
                "carName='" + carName + '\'' +
                ", pageNum=" + pageNum +
                ", pageSize=" + pageSize +
                '}';
    }
}
