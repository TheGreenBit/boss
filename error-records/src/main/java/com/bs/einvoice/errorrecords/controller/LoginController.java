package com.bs.einvoice.errorrecords.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class LoginController {

    @RequestMapping("/{uri}")
    public String login() {
        return "login";
    }
}
