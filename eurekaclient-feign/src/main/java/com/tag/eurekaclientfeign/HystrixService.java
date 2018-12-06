package com.tag.eurekaclientfeign;

import org.springframework.stereotype.Component;

/**
 * @author tag
 * @date 2018/12/6 15:49
 * @description
 */
@Component
public class HystrixService implements UserServiceFeign{

    @Override
    public String getClient() {
        return "sorry111111111111";
    }
}
