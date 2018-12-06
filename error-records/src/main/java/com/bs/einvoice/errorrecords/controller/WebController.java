package com.bs.einvoice.errorrecords.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/web")
public class WebController {

    @RequestMapping("/{uri}")
    public String login(@PathVariable("uri") String uri) {
        return uri;
    }

}
