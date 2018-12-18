package com.callback;

import java.util.Map;

/**
 * <p>description:</p>
 *
 * @author 竹
 * on 2018/4/23.
 */
@FunctionalInterface
public interface ICallback {

    void call(Map<String, String> context) throws Exception;

    /**
     * default method
     */
    default void execute() throws Exception {
        call(null);
    }
}
