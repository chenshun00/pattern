package com.filter;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;

import java.util.List;

/**
 * <p>description:set about IFilter</p>
 * <code>
 *     class FilterChain{
 *         private List<Filter> filter ;
 *         private Invoke invoke ;
 *         public Object doNext(){
 *              //compare index and filter's size,
 *              if(index equals size -1 ){
 *                  invoke.invoke();
 *              }else{
 *                  filter.get(++index).handle(this);
 *              }
 *         }
 *         get...  set...
 *     }
 * </code>
 * @author zhu
 *         on 2018/4/23.
 */
@Data
@Slf4j
public class FilterChain {

    /**
     * <p>handle message and invoke next</p>
     *
     * @param message the message will be handle(any param include Object)
     */
    public void doNext(String message) {
        if (index == filterList.size() - 1) {
            log.info("later , do something");
        } else {
            filterList.get(++index).handle(message, this);
        }
    }

    public FilterChain(List<IFilter> filterList) {
        this.filterList = filterList;
    }

    /**
     * index , compare the index and size , invoke handler
     */
    private static Integer index = -1;
    private List<IFilter> filterList;
}
