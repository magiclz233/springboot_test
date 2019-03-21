package com.cnpc.web;

import com.cnpc.model.User;
import com.cnpc.repository.UserRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {
    private UserRepository userRepository;

    @RequestMapping("/")
    public String index() {
        return "redirect:/list";
    }

    @RequestMapping("/list")
    public String list(Model model, @RequestParam(value = "page", defaultValue = "0") Integer page
            , @RequestParam(value = "size", defaultValue = "6") Integer size) {
        Sort sort = new Sort( Sort.Direction.ASC, "id" );
        Pageable pageable = PageRequest.of( page, size, sort );
        Page<User> users = userRepository.findAll( pageable );
        model.addAttribute( "users", users );
        return "user/list";
    }

    @RequestMapping("/toAdd")
    public String toAdd() {
        return "user/userAdd";
    }

    @RequestMapping("")
    public String add(){
        return "user/userAdd";
    }
}
