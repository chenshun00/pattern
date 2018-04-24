package com.filter;


import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>description:</p>
 *
 * @author 竹
 *         on 2018/4/24.
 */
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class FilterManager {

    @Getter
    private List<IFilter> filterList = new ArrayList<>(16);

    public FilterManager add(IFilter filter){
        check(filter);
        filterList.add(filter);
        return this;
    }
//    public FilterManager addFirst(IFilter filter){
//        check(filter);
//        List<IFilter> iFilters = Collections.synchronizedList(filterList);
//        filterList.set(0,filter);
//        filterList.addAll(iFilters);
//        return this;
//    }


    private void check(IFilter filter){
        if (filterList.contains(filter)){
            throw new IllegalArgumentException("duplice filter,planse check agiin :" + filter);
        }
    }

    private final static class FilterManagerHolder{
        private final static FilterManager ME = new FilterManager();
        private static FilterManager me(){
            return ME;
        }
    }
    public static FilterManager me(){
        return FilterManagerHolder.me();
    }


}
