package com.codeup.codercollective.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class FlaviconController {

    @GetMapping("favicon.ico")
    @ResponseBody
    public void disableFavicon() {
        //Method is void to avoid browser 404 issue by returning nothing in the response.
    }

}
