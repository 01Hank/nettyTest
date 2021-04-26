package com.nettyTest.ClassTest;

import com.nettyTest.ClassTest.BaseClassPac.CarClass;
import com.nettyTest.ClassTest.BaseClassPac.GiftClass;
import com.nettyTest.ClassTest.BaseClassPac.HouseClass;

public class Test {
    public static void main(String[] args) {
        CarClass carClass = new CarClass();
        GiftClass giftClass = new GiftClass();
        HouseClass houseClass = new HouseClass();

        new TestClass().init();
    }
}
