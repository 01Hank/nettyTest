package com.nettyTest.ClassTest;


import com.nettyTest.Annotation.ClassHandler;


import java.util.List;

public class TestClass<T extends AbstractBaseClass> implements TestIn {
    private T t;
    //类文件
    private List<Class<? extends AbstractBaseClass>> aClassList;


    @Override
    public void init() {
        try {
            //获取已经实例化的所有子类
            aClassList = AbstractBaseClass.childList;
            for (Class<? extends AbstractBaseClass> aClass : aClassList) {
                ClassHandler annotation = aClass.getAnnotation(ClassHandler.class);
                if (annotation != null) {
                    AbstractBaseClass baseClass = aClass.newInstance();
                    baseClass.test();
                    BaseBean bean = (BaseBean) annotation.clzz().newInstance();
                    bean.setValue();
                    bean.printValue();
                }

            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
