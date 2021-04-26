package com.nettyTest.ClassTest.BaseClassPac;

import com.nettyTest.Annotation.ClassHandler;
import com.nettyTest.ClassTest.AbstractBaseClass;
import com.nettyTest.ClassTest.BaseBeanClass.GiftBean;


@ClassHandler(clzz = GiftBean.class)
public class GiftClass extends AbstractBaseClass {
    public GiftClass() {
        register();
    }

    @Override
    public void test() {
        System.out.println("这是彩礼");
    }

    @Override
    public void register() {
        //注册到父类去
        if(!super.childList.contains(this.getClass())){
            super.childList.add(this.getClass());
        }
    }
}
