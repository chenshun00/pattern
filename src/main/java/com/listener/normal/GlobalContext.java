package com.listener.normal;

import lombok.extern.slf4j.Slf4j;

import java.io.IOException;
import java.io.InputStream;
import java.util.Map;
import java.util.Properties;
import java.util.concurrent.ConcurrentHashMap;

/**
 * <p>description:全局配置</p>
 *
 * @author 竹
 *         on 2018/4/15.
 */
@Slf4j
public class GlobalContext {

    private Map<String,Object> context = new ConcurrentHashMap<>(16);

    private GlobalContext(){
        InputStream resourceAsStream = GlobalContext.class.getClassLoader().
                getResourceAsStream("listener.properties");
        Properties properties = new Properties();
        try {
            properties.load(resourceAsStream);
            String key1 = (String) properties.get("key1");
            Object value1 = properties.get("value1");
            context.putIfAbsent(key1,value1);
            String key2 = (String) properties.get("key2");
            Object value2 =  properties.get("value2");
            context.putIfAbsent(key2,value2);


            //读取监听器
            String listenerName1 = (String) properties.get("listenerName1");
            String listenerName2 = (String) properties.get("listenerName2");
            String listenerName3 = (String) properties.get("listenerName3");

            String class1 = (String) properties.get("listenerPath1");
            String class2 = (String) properties.get("listenerPath2");
            String class3 = (String) properties.get("listenerPath3");

            Object first = ClassKit.forName(class1);
            Object second = ClassKit.forName(class2);
            Object third = ClassKit.forName(class3);

            if (!(first instanceof Listener) || !(second instanceof Listener) ||
                    !(third instanceof Listener)){
                throw new IllegalArgumentException("添加监听器失败!");
            }else {
                listenerManager.register((Listener) first)
                .register((Listener) second)
                .register((Listener) third);
            }
            context.putIfAbsent(listenerName1,first);
            context.putIfAbsent(listenerName2,second);
            context.putIfAbsent(listenerName3,third);

            startListenInit();

        } catch (IOException e) {
            log.error("应用启动失败,读取配置文件listener.properties出错");
            e.printStackTrace();
        }
    }

    private void startListenInit() {
        listenerManager.triggerInit();
    }

    private ListenerManager listenerManager = ListenerManager.me();

    private static class GlobalContextHolder{
        private static GlobalContext me(){
            return new GlobalContext();
        }
    }

    public static GlobalContext getInstance(){
        return GlobalContextHolder.me();
    }

    public Object getContextValue(String key){
        return context.getOrDefault(key,"");
    }
}
