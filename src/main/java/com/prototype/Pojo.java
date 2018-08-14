package com.prototype;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import lombok.extern.slf4j.Slf4j;

import java.io.Serializable;
import java.util.Date;

/**
 * 使用clone拷贝的时候，是不执行构造函数的，切记
 *
 * @author luobo.cs@raycloud.com
 * @since 2018/8/14
 */
@Getter
@Setter
@Slf4j
@ToString
public class Pojo implements Serializable, Cloneable {
    private static final long serialVersionUID = 1L;

    private String name;
    private Integer userId;
    private Long key;
    private Date birthday;

    public Pojo() {
        log.debug("构造函数初始化");
    }

    @Override
    protected Pojo clone() {
        Pojo pojo = null;
        try {
            pojo = (Pojo) super.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        return pojo;
    }
}
