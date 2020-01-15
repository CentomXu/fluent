package com.hsbc.fluent.Config;

import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix ="file")
public class AppSettings {
    private String uploadpath;
    public String getUploadpath() {
        return uploadpath;
    }
    public void setUploadpath(String uploadpath) {
        this.uploadpath = uploadpath;
    }
}

