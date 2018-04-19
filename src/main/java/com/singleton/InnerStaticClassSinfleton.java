package com.singleton;

/**
 * <p>静态内部类单例模式</p>
 * @author 竹
 *         on 2018/4/15.
 */
public class InnerStaticClassSinfleton {
    private InnerStaticClassSinfleton(){}
    private static class InnerStaticClassSinfletonHolder{
        private final static InnerStaticClassSinfleton ME = new InnerStaticClassSinfleton();
        private static InnerStaticClassSinfleton me(){
            return ME;
        }
    }
    public static InnerStaticClassSinfleton me(){
        return InnerStaticClassSinfletonHolder.me();
    }
}
