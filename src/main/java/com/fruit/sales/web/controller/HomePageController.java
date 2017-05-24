package com.fruit.sales.web.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by chundong.hcd on 2017/5/24.
 */
@RequestMapping("/*")
@Controller
public class HomePageController {

    private static final Logger logger = LoggerFactory.getLogger(HomePageController.class);

    @RequestMapping(value = "", method = RequestMethod.GET)
    public String index(){
        return "index";
    }
}
