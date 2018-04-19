package com.listener.annotation;

/**
 * <p>galbol config</p>
 * @author zhu
 */
public class GalbolContext {



    /**
     * static inner class (single)
     */
    private static class GalbolContextHolder{
        private final static GalbolContext ME = new GalbolContext();
        private static GalbolContext me(){
            return ME;
        }
    }

    private GalbolContext(){}

    public static GalbolContext me(){
        return GalbolContextHolder.me();
    }
}
