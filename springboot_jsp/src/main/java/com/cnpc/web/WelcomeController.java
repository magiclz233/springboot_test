package com.cnpc.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;


import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.Map;

@Controller
public class WelcomeController {

    @GetMapping("/")
    public String welcome(ModelMap model){

        model.put( "time",new Date(  ) );
        model.put( "message","我是你哥哥" );

        return "welcome";
    }

    @GetMapping("/user")
    public String user(Map<String,Object> map, HttpServletRequest request){
        map.put( "username","magic" );
        map.put( "age",120 );
        request.getSession().setAttribute( "count",9 );

        return "user";

    }
}
