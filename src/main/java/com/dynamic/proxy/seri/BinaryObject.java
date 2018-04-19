package com.dynamic.proxy.seri;



/**
 * <p>Serializable object</p>
 * @author zhu
 */
public class BinaryObject {

    private byte[] context;
    private String flag;

    public byte[] getContext() {
        return context;
    }

    public void setContext(byte[] context) {
        this.context = context;
    }

    public String getFlag() {
        return flag;
    }

    public void setFlag(String flag) {
        this.flag = flag;
    }
}
