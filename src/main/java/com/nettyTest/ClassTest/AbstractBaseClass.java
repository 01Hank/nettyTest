package com.nettyTest.ClassTest;

import java.util.ArrayList;
import java.util.List;

public abstract class AbstractBaseClass implements BaseClass{
    protected static List<Class<? extends AbstractBaseClass>> childList = new ArrayList<>();
    public  abstract  void register();

}
