package com.nicodewet.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
class HomeAndLoginController {

    @RequestMapping("/")
    String index() {
        return "index";
    }
    
    @RequestMapping("/login")
    String login() {
    	return "login";
    }

    @RequestMapping("properties")
    @ResponseBody
    java.util.Properties properties() {
        return System.getProperties();
    }
}
