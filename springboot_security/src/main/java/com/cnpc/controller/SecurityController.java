package com.cnpc.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class SecurityController {

    @RequestMapping("/")
    public String index(){
        return "index";
    }
    @PreAuthorize( "hasAnyAuthority('USER','ADMIN')" )
    @RequestMapping("/content")
    public String content(){
        return "content";
    }

    @RequestMapping("/login")
    public String login(){
        return "login";
    }

    @PreAuthorize( "hasAuthority('ADMIN')" )
    @RequestMapping("/admin")
    public String admin(){
        return "admin";

    }

}
