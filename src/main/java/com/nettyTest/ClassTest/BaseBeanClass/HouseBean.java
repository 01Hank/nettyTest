package com.nettyTest.ClassTest.BaseBeanClass;

import com.nettyTest.ClassTest.BaseBean;

public class HouseBean extends BaseBean {
    private int price;

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    @Override
    public void setValue(int value) {
        this.price = value;
    }

    @Override
    public void printValue() {
        System.out.println("房子价值：" + this.price);
    }
}
