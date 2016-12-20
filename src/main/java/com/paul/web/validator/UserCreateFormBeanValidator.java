package com.paul.web.validator;

import com.paul.service.def.UserService;
import com.paul.web.formBean.UserCreateFormBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

/**
 * Created by paulzhang on 20/12/2016.
 */
@Component
public class UserCreateFormBeanValidator implements Validator {

    @Autowired
    private UserService userService;

    @Override
    public boolean supports(Class<?> aClass) {
        return UserCreateFormBean.class.equals(aClass);
    }

    @Override
    public void validate(Object o, Errors errors) {
        UserCreateFormBean bean = (UserCreateFormBean) o;
        if (userService.isEmailDuplicated(bean.getEmail())) {
            errors.rejectValue("email", "Duplicated");
        }

        if (!bean.getPassword1().equals(bean.getPassword2())) {
            errors.rejectValue("password2", "NotEqual", "Two passwords are not the same");
        }
    }
}
