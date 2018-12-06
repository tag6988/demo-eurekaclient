package com.tag.serviceuser;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author tag
 * @date 2018/12/5 16:47
 * @description
 */
@Controller
public class UserController {

    @GetMapping("/index")
    public String getPage(){
        return "index";
    }

    @ResponseBody
    @GetMapping("/index3")
    public String getPage2(){
        return "index3";
    }

    @GetMapping("/index2")
    public String getRedirect(HttpServletRequest request, HttpServletResponse response) throws IOException {
        //response.sendRedirect("http://127.0.0.1:8040/index");
        return "redirect:user/index3";
    }
}
