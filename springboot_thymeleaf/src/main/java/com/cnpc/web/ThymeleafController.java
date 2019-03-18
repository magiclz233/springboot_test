package com.cnpc.web;

import com.cnpc.model.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Controller
public class ThymeleafController {

    @RequestMapping("/hello")
    public String hello(ModelMap modelMap){
        modelMap.addAttribute( "message","罗璋magiclz233111" );
        return "hello";
    }

    @RequestMapping("/string")
    public String string(ModelMap modelMap){
        modelMap.addAttribute( "username","罗璋" );
        return "string";
    }

    @RequestMapping("/ifUnless")
    public String ifUnless(ModelMap modelMap){
        modelMap.addAttribute( "flag","yes" );
        return "ifUnless";
    }

    @RequestMapping("/getUsers")
    public String getUsers(ModelMap modelMap){

        modelMap.addAttribute( "users",getUserList() );
        return "list";
    }

    @RequestMapping("/url")
    public String url(ModelMap map) {
        map.addAttribute("type", "link");
        map.addAttribute("pageId", "springcloud/2017/09/11/");
        map.addAttribute("img", "http://www.ityouknow.com/assets/images/neo.jpg");
        return "url";
    }

    @RequestMapping("/switch")
    public String switchcase(ModelMap map) {
        map.addAttribute("sex", "man");
        return "switch";
    }

    @RequestMapping("/http")
    public String httpChoose(HttpServletRequest request) {
        request.setAttribute( "request","i am request" );
        request.getSession().setAttribute( "session","i am session" );
        return "http";
    }

    @RequestMapping("/utility")
    public String utility(ModelMap map) {
        map.addAttribute( "userName","magic" );
        map.addAttribute( "users",getUserList() );
        map.addAttribute( "count",12 );
        map.addAttribute( "date",new Date(  ) );
        return "utility";
    }




    private List<User> getUserList(){
        List<User> list=new ArrayList<User>();
        User user1=new User("大牛",12,"123456");
        User user2=new User("小牛",6,"123563");
        User user3=new User("纯洁的微笑",66,"666666");
        list.add(user1);
        list.add(user2);
        list.add(user3);
        return  list;
    }
}
