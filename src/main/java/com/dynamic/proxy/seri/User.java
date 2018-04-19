package com.dynamic.proxy.seri;

import lombok.Builder;
import lombok.Data;

import java.io.Serializable;

@Builder
@Data
public class User implements Serializable{

    private Integer age;
    private String name;

}
