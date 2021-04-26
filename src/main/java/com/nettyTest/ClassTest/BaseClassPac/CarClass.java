package com.nettyTest.ClassTest.BaseClassPac;

import com.nettyTest.Annotation.ClassHandler;
import com.nettyTest.ClassTest.AbstractBaseClass;
import com.nettyTest.ClassTest.BaseBeanClass.CarBean;

@ClassHandler(clzz = CarBean.class)
public class CarClass extends AbstractBaseClass {
    public CarClass() {
        register();
    }

    @Override
    public void test() {
        System.out.println("这是车");
    }

    @Override
    public void register() {
        //注册到父类去
        if(!super.childList.contains(this.getClass())){
            super.childList.add(this.getClass());
        }

    }
}
