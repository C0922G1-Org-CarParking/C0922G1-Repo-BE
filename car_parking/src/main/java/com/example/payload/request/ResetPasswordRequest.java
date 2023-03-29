package com.example.payload.request;

import javax.validation.constraints.Size;

public class ResetPasswordRequest {

    private String username;
    private String oldPassword;

    @Size(min = 6,max = 20)
    private String newPassword;

    @Size(min = 6,max = 20)
    private String confirmNewPassword;

    public ResetPasswordRequest() {
    }

    public ResetPasswordRequest(String username, String oldPassword, String newPassword, String confirmNewPassword) {
        this.username = username;
        this.oldPassword = oldPassword;
        this.newPassword = newPassword;
        this.confirmNewPassword = confirmNewPassword;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getOldPassword() {
        return oldPassword;
    }

    public void setOldPassword(String oldPassword) {
        this.oldPassword = oldPassword;
    }

    public String getNewPassword() {
        return newPassword;
    }

    public void setNewPassword(String newPassword) {
        this.newPassword = newPassword;
    }

    public String getConfirmNewPassword() {
        return confirmNewPassword;
    }

    public void setConfirmNewPassword(String confirmNewPassword) {
        this.confirmNewPassword = confirmNewPassword;
    }
}
