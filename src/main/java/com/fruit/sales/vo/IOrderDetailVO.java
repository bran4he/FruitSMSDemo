package com.fruit.sales.vo;

import org.apache.commons.lang3.builder.ReflectionToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

/**
 * Created by chundong.hcd on 2017/4/20.
 */
public class IOrderDetailVO {

    private String id;

    private Integer orderUnit;

    private String fruitId;
    private String fruitName;

    public IOrderDetailVO() {super(); }

    @Override
    public String toString() {
        return ReflectionToStringBuilder.toString(this, ToStringStyle.JSON_STYLE);
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Integer getOrderUnit() {
        return orderUnit;
    }

    public void setOrderUnit(Integer orderUnit) {
        this.orderUnit = orderUnit;
    }

    public String getFruitId() {
        return fruitId;
    }

    public void setFruitId(String fruitId) {
        this.fruitId = fruitId;
    }

    public String getFruitName() {
        return fruitName;
    }

    public void setFruitName(String fruitName) {
        this.fruitName = fruitName;
    }
}
