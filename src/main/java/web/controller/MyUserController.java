package web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import web.model.User;
import web.service.UserService;

import java.util.List;

@Controller
@RequestMapping(value = "/users")
public class MyUserController {

    @Autowired
    private UserService userService;

    @RequestMapping
    public  String showAllUser(Model model){
        List<User> allUser = userService.getAllUser();
        model.addAttribute("allUsers", allUser);
        return "allusers";
    }

    @RequestMapping("/addNewUser")
    public String addNewUser(@ModelAttribute("user") User user){

        return "userinfo";
    }
    @PostMapping
    public String saveUser(@ModelAttribute("user") User user){

        userService.saveUser(user);

        return "redirect:/users";
    }
    @GetMapping("/{userId}/updateInfo")
    public String updateInfo(@PathVariable("userId") int id, Model model){
        User user = userService.getUser(id);
        model.addAttribute("user", user);
        return "userupdate";

    }
    @PostMapping("/{userId}")
    public String update(@ModelAttribute("user") User user, @PathVariable("userId") int id){
        userService.updateUser(id, user);
        return "redirect:/users";
    }

    @GetMapping(value = "/{userId}")
    public String deleteUser(@ModelAttribute("user") @PathVariable("userId") int id){
        userService.deleteUser(id);

        return "redirect:/users";
    }
}
