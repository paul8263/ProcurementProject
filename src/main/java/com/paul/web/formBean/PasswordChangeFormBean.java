package com.paul.web.formBean;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotEmpty;

/**
 * Created by paulzhang on 20/12/2016.
 */
public class PasswordChangeFormBean {
    @NotEmpty
    @Length(min = 6, max = 16)
    private String oldPassword;
    @NotEmpty
    @Length(min = 6, max = 16)
    private String newPassword1;

    @NotEmpty
    @Length(min = 6, max = 16)
    private String newPassword2;

    public String getOldPassword() {
        return oldPassword;
    }

    public void setOldPassword(String oldPassword) {
        this.oldPassword = oldPassword;
    }

    public String getNewPassword1() {
        return newPassword1;
    }

    public void setNewPassword1(String newPassword1) {
        this.newPassword1 = newPassword1;
    }

    public String getNewPassword2() {
        return newPassword2;
    }

    public void setNewPassword2(String newPassword2) {
        this.newPassword2 = newPassword2;
    }
}
