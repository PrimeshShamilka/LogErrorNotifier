package com.company;

import java.util.List;

public class Application
{
    private String logFilePath;
    private String applicationName;
    private List<SysAdmin> users;

    public String getLogFilePath() {
        return logFilePath;
    }

    public void setLogFilePath(String logFilePath) {
        this.logFilePath = logFilePath;
    }

    public String getApplicationName() {
        return applicationName;
    }

    public void setApplicationName(String applicationName) {
        this.applicationName = applicationName;
    }

    public List<SysAdmin> getUsers() {
        return users;
    }

    public void setUsers(List<SysAdmin> users) {
        this.users = users;
    }

}
