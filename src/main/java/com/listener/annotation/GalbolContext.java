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
        private static GalbolContext me(){
            return new GalbolContext();
        }
    }

    private GalbolContext(){}

    public static GalbolContext me(){
        return GalbolContextHolder.me();
    }
}
