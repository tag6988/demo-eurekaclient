package com.tag.eurekaclientfeign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @author tag
 * @date 2018/12/5 15:45
 * @description
 */

@FeignClient(value = "eureka-client1", fallback = HystrixService.class)
public interface UserServiceFeign {

    @RequestMapping(value = "/cloud", method = RequestMethod.GET)
    String getClient();

}
