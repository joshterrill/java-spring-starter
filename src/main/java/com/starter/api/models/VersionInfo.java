package com.starter.api.models;


public class VersionInfo {

    private String version;
    private String app;

    public VersionInfo() {}

    public VersionInfo(String version, String app) {
        this.version = version;
        this.app = app;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public String getApp() {
        return app;
    }

    public void setApp(String app) {
        this.app = app;
    }
}