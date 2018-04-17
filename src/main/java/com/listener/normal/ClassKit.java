package com.listener.normal;

/**
 * <p>description:反射基础工具</p>
 *
 * @author 竹
 *         on 2018/4/15.
 */
public class ClassKit {

    public static Object forName(String name) {
        Class<?> aClass;
        Object o = null;
        try {
            aClass = Class.forName(name);
            try {
                o = aClass.newInstance();
                if (o == null) {
                    throw new Exception("反射异常");
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return o;
    }

}
