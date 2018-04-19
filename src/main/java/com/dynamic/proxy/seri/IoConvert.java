package com.dynamic.proxy.seri;

import lombok.extern.slf4j.Slf4j;

import java.io.*;

/**
 * <p>object -> byte[] , byte[] -> object</p>
 * @author zhu
 */
@Slf4j
public class IoConvert{

    public static  <T> T toObject(byte[] context,Class<T> clazz){
        Object object =null;
        try (ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(context);
             ObjectInputStream objectOutputStream = new ObjectInputStream(byteArrayInputStream)) {
             object = objectOutputStream.readObject();
        }catch (Exception e){
            e.printStackTrace();
        }
        return clazz.cast(object);
    }


    public static byte[] toBinary(Object object) {
        byte[] bytes = null;
        try (ByteArrayOutputStream byteArrayInputStream = new ByteArrayOutputStream();
             ObjectOutputStream objectOutputStream = new ObjectOutputStream(byteArrayInputStream)) {
            objectOutputStream.writeObject(object);
            objectOutputStream.flush();
            bytes = byteArrayInputStream.toByteArray();
        }catch (Exception e){
          e.printStackTrace();
        }
        return bytes;
    }

    public static void main(String[] args) {
        byte[] bytes = toBinary("chen");

        String object = toObject(bytes,String.class);
        log.info("deSerialize {}",object);
    }
}
