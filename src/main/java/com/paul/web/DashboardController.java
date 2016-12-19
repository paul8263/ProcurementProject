package com.paul.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by paulzhang on 19/12/2016.
 */
@Controller
@RequestMapping(value = "/dashboard/")
public class DashboardController {
    @GetMapping()
    public String showDashboard() {
        return "dashboard/dashboard";
    }
}
