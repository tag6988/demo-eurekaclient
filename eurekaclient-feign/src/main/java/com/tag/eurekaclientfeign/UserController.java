package com.tag.eurekaclientfeign;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author tag
 * @date 2018/12/5 15:48
 * @description
 */
@RestController
public class UserController {

    @Autowired
    UserServiceFeign userServiceFeign;

    @GetMapping(value = "/feign-cloud")
    public String sayHi() {
        return userServiceFeign.getClient();
    }

}
