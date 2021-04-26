package com.nettyTest.ClassTest.BaseClassPac;

import com.nettyTest.Annotation.ClassHandler;
import com.nettyTest.ClassTest.AbstractBaseClass;
import com.nettyTest.ClassTest.BaseBeanClass.HouseBean;

@ClassHandler(clzz = HouseBean.class)
public class HouseClass extends AbstractBaseClass {
    public HouseClass() {
        register();
    }

    @Override
    public void test() {
        System.out.println("这是房");
    }

    @Override
    public void register() {
        //注册到父类去
        if(!super.childList.contains(this.getClass())){
            super.childList.add(this.getClass());
        }
    }
}
