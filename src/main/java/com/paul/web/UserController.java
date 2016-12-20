package com.paul.web;

import com.paul.domain.User;
import com.paul.service.def.UserHelper;
import com.paul.service.def.UserService;
import com.paul.web.formBean.PasswordChangeFormBean;
import com.paul.web.validator.PasswordChangeFormBeanValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

/**
 * Created by paulzhang on 15/12/2016.
 */
@Controller
@RequestMapping(value = "/user")
public class UserController {
    @Autowired
    private UserService userService;

    @Autowired
    private PasswordChangeFormBeanValidator passwordChangeFormBeanValidator;

    @Autowired
    private UserHelper userHelper;

    @InitBinder
    public void bind(WebDataBinder binder) {
        binder.addValidators(passwordChangeFormBeanValidator);
    }

    @GetMapping(value = "/password")
    public String showChangePassword(Model model) {
        PasswordChangeFormBean formBean = new PasswordChangeFormBean();
        model.addAttribute("passwordChanger", formBean);
        return "changePassword";
    }


    @PostMapping(value = "/password")
    public String changePasswordOnSubmit(@ModelAttribute @Valid PasswordChangeFormBean passwordChanger, BindingResult bindingResult) throws Exception {
        if (bindingResult.hasErrors()) return "changePassword";

        User user = userHelper.getUserFromAuthentication();

        if(!userService.changePassword(user.getEmail(), passwordChanger.getOldPassword(), passwordChanger.getNewPassword1())) {
            bindingResult.rejectValue("oldPassword", "NotEqual");
            return "changePassword";
        }
        return "passwordChangeSuccess";
    }
}
