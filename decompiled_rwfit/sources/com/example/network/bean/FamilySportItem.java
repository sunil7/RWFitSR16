package com.example.network.bean;

import java.math.BigDecimal;

/* loaded from: classes.dex */
public class FamilySportItem {
    private BigDecimal bigDecimalValue;
    private Integer type;
    private Integer value;

    public FamilySportItem() {
    }

    public BigDecimal getBigDecimalValue() {
        return this.bigDecimalValue;
    }

    public Integer getType() {
        return this.type;
    }

    public Integer getValue() {
        return this.value;
    }

    public void setBigDecimalValue(BigDecimal bigDecimal) {
        this.bigDecimalValue = bigDecimal;
    }

    public void setType(Integer num) {
        this.type = num;
    }

    public void setValue(Integer num) {
        this.value = num;
    }

    public String toString() {
        return "FamilySportItem{type=" + this.type + ", value=" + this.value + ", bigDecimalValue=" + this.bigDecimalValue + '}';
    }

    public FamilySportItem(Integer num, Integer num2) {
        this.value = num;
        this.type = num2;
    }

    public FamilySportItem(Integer num, Integer num2, BigDecimal bigDecimal) {
        this.value = num;
        this.type = num2;
        this.bigDecimalValue = bigDecimal;
    }
}
