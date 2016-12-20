package com.paul.web;

import com.paul.service.def.UserService;
import com.paul.web.formBean.UserCreateFormBean;
import com.paul.web.validator.UserCreateFormBeanValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

/**
 * Created by paulzhang on 28/11/2016.
 */
@Controller
@RequestMapping(value = "/")
public class MainController {

    @Autowired
    private UserService userService;

    @Autowired
    private UserCreateFormBeanValidator userCreateFormBeanValidator;

    @InitBinder
    public void bind(WebDataBinder binder) {
        binder.addValidators(userCreateFormBeanValidator);
    }

    @GetMapping
    public String showIndex() {
        return "index";
    }

    @GetMapping(value = "about")
    public String showAbout() {
        return "about";
    }

    @GetMapping(value = "signup")
    public String showSignUp(Model model) {
        model.addAttribute("userCreateFormBean", new UserCreateFormBean());
        return "signUp";
    }

    @PostMapping(value = "signup")
    public String createNewUserOnSubmit(@ModelAttribute @Valid UserCreateFormBean userCreateFormBean, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) return "signUp";
        String email = userCreateFormBean.getEmail();
        String password = userCreateFormBean.getPassword1();
        userService.signUp(email, password);
        userService.login(email, password);
        return "redirect:/dashboard/";
    }

    @GetMapping(value = "login")
    public String showLogin() {
        return "login";
    }

    @GetMapping(value = "logout_success")
    public String showLogoutSuccess() {
        return "logoutSuccess";
    }
}
