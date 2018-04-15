package com.singleton;

/**
 * <p>静态内部类单例模式</p>
 * @author 竹
 *         on 2018/4/15.
 */
public class InnerStaticClassSinfleton {
    private InnerStaticClassSinfleton(){}
    private static class InnerStaticClassSinfletonHolder{
        public static InnerStaticClassSinfleton me(){
            return new InnerStaticClassSinfleton();
        }
    }
    public static InnerStaticClassSinfleton me(){
        return InnerStaticClassSinfletonHolder.me();
    }
}
