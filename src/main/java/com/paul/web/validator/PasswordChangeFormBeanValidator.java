package com.paul.web.validator;

import com.paul.web.formBean.PasswordChangeFormBean;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

/**
 * Created by paulzhang on 20/12/2016.
 */
@Component
public class PasswordChangeFormBeanValidator implements Validator {
    @Override
    public boolean supports(Class<?> aClass) {
        return PasswordChangeFormBean.class.equals(aClass);
    }

    @Override
    public void validate(Object o, Errors errors) {
        PasswordChangeFormBean bean = (PasswordChangeFormBean) o;
        if (!bean.getNewPassword2().equals(bean.getNewPassword1())) {
            errors.rejectValue("newPassword2", "NotEqual", "Two passwords are not the same");
        }
    }
}
