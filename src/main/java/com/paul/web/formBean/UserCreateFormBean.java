package com.paul.web.formBean;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotEmpty;

/**
 * Created by paulzhang on 20/12/2016.
 */
public class UserCreateFormBean {
    @NotEmpty
    @Email
    private String email;

    @NotEmpty
    @Length(min = 6, max = 16)
    private String password1;

    @NotEmpty
    @Length(min = 6, max = 16)
    private String password2;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword1() {
        return password1;
    }

    public void setPassword1(String password1) {
        this.password1 = password1;
    }

    public String getPassword2() {
        return password2;
    }

    public void setPassword2(String password2) {
        this.password2 = password2;
    }
}
