package com.paul.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by paulzhang on 28/11/2016.
 */
@Controller
@RequestMapping(value = "/")
public class MainController {

    @GetMapping
    public String showIndex() {
        return "root";
    }
}
