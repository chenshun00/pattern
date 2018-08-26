package com.cglib;

import net.sf.cglib.core.DefaultNamingPolicy;

/**
 * @author luobo.cs@raycloud.com
 * @since 2018/8/25
 */
public class MyDefaultNamingPolicy extends DefaultNamingPolicy {
    @Override
    protected String getTag() {
        return "ByPattern";
    }
}
