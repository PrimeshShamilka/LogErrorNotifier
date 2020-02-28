package com.company;

import com.company.catcher.Catcher;
import com.company.catcher.CatcherFactory;
import com.company.notifier.Notifier;
import com.company.notifier.NotifierFactory;
import com.company.repository.application.FileApplicationRepo;
import com.company.repository.severity.FileSeverityRepo;
import com.company.repository.severity.SeverityRepo;

import java.util.List;

public class Main {

    public static void main(String[] args) {
        // Controller code
        FileApplicationRepo appRepo = new FileApplicationRepo();
        List<Application> appList = appRepo.getApplications();

        for (Application application : appList) {
            SeverityRepo severityRepo = new FileSeverityRepo(application.getLogFilePath());

            List<String> severityList = severityRepo.getErrorLevels();

            CatcherFactory catcherFactory = new CatcherFactory();
            Catcher catcher = catcherFactory.getInstance("ERROR",severityList);

            List<String> errorList = catcher.catchFaults();

            for (String error : errorList){
                List<SysAdmin> sysAdminList = application.getUsers();

                for(SysAdmin sysAdmin : sysAdminList){
                    List<String> notifMethodList = sysAdmin.getNotificationTypes();

                    for(String notifMethod: notifMethodList){
                        NotifierFactory notifierFactory = new NotifierFactory();
                        Notifier notifier = notifierFactory.getInstance(notifMethod);
                        notifier.notifyUser(sysAdmin,application);
                    }
                }
            }

        }
    }
}
