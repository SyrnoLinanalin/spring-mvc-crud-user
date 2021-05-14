package web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import web.model.User;
import web.service.UserService;

import java.util.List;

@Controller
public class MyUserController {
    @Autowired
    private UserService userService;

    @RequestMapping("/user")
    public  String showAllUser(Model model){
        List<User> allUser = userService.getAllUser();
        model.addAttribute("allUsers", allUser);
        return "allusers";
    }
}
