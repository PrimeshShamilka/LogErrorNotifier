package com.company.notifier;

import com.company.Application;
import com.company.SysAdmin;

public class EmailNotifier implements Notifier {
    @Override
    public void notifyUser(SysAdmin user, Application application) {
        System.out.println("System Admin "+ user.getName() + ", of "+application.getApplicationName() +" is notified. Email sent to "+user.getEmail());
    }
}
