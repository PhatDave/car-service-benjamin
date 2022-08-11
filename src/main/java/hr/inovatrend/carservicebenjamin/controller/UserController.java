package hr.inovatrend.carservicebenjamin.controller;

import hr.inovatrend.carservicebenjamin.entity.User;
import hr.inovatrend.carservicebenjamin.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/user")
@SessionAttributes("user")
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;

    @GetMapping
    public String index(Model model) {
        model.addAttribute("users", userService.getAll());
        List<User> users = userService.getAll();
        return "users-info";
    }

    @GetMapping(value = "show/{id}")
    public String showId(@PathVariable("id") Long id, Model model){
        Optional<User> user = userService.getUserById(id);
        model.addAttribute("User", user);
        return "user-info";
    }

    @GetMapping("/add")
    public String getRegisterForm(Model model) {
        model.addAttribute("user", new User());
        return "user-add";
    }

    @PostMapping("/add")
    public String addUser(@ModelAttribute User user) {
        userService.addUser(user);
        return "user-info";
    }

    @GetMapping(value = "/deleteUser/{id}")
    public String deleteUserById(@PathVariable Long id) {
        userService.deleteUserById(id);
        return "redirect:/user/";
    }

    @GetMapping("/edit/{id}")
    public String editUserById(Model model, @PathVariable Long id){
        Optional<User> user = userService.getUserById(id);
        if(user.isPresent()) {
            model.addAttribute("user", user.get());
            return "user-edit";
        }
        return "user-info";
    }

}