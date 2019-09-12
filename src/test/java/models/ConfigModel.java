package models;

import enums.Browser;

public class ConfigModel {
    private  Browser browser;
    private String emailFormat;
    private String passwordFormat;

    public ConfigModel() {

    }

    public Browser getBrowser() {
        return browser;
    }

    public void setBrowser(Browser browser) {
        this.browser = browser;
    }

    public String getEmailFormat() {
        return emailFormat;
    }

    public void setEmailFormat(String emailFormat) {
        this.emailFormat = emailFormat;
    }

    public String getPasswordFormat() {
        return passwordFormat;
    }

    public void setPasswordFormat(String passwordFormat) {
        this.passwordFormat = passwordFormat;
    }
}
