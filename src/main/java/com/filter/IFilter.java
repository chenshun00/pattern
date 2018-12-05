package com.filter;

/**
 * <p>description:</p>
 *
 * @author 竹
 *         on 2018/4/23.
 */
@FunctionalInterface
public interface IFilter {

//    default boolean prehandler(Object object,FilterChain filterChain){
//        return true;
//    }

    Object handle(String message,FilterChain filterChain);

}
