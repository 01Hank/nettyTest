package com.nettyTest.ClassTest.BaseBeanClass;

import com.nettyTest.ClassTest.BaseBean;

public class CarBean extends BaseBean {
    private int size;

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    @Override
    public void setValue(int value) {
        this.size = value;
    }

    @Override
    public void printValue() {
        System.out.println("车长：" + this.size);
    }
}
