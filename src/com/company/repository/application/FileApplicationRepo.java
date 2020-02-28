package com.company.repository.application;

import com.company.Application;
import com.company.SysAdmin;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.awt.desktop.AppForegroundListener;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class FileApplicationRepo implements ApplicationRepo {
    @Override
    public List<Application> getApplications() {

        // READ THE CONFIG FILE AND RETRIEVE APPLICATION LIST

        List<Application> applicationList = new ArrayList<>();
        JSONParser jsonParser = new JSONParser();

        try {
            JSONArray appList = (JSONArray) jsonParser.parse(new FileReader("/home/primesh/LogErrorNotifier/src/com/company/config/config.json"));

            Iterator<JSONObject> appIterator = appList.iterator();
            while(appIterator.hasNext()) {
                JSONObject applicationJson = appIterator.next();

                String filePath = (String) applicationJson.get("log_file");
                String appName = (String) applicationJson.get("application_name");

                List<SysAdmin> sysAdminList = new ArrayList<>();

                JSONArray userList = (JSONArray) applicationJson.get("users");
                Iterator<JSONObject> userIterator = userList.iterator();
                while(userIterator.hasNext()) {
                    JSONObject userJson = userIterator.next();

                    String userName = (String) userJson.get("name");
                    String userEmail = (String) userJson.get("email");
                    String userPhoneNo = (String) userJson.get("phone");
                    List<String> userNotifTypes = Arrays.asList(((String) userJson.get("notificationTypes")).split(","));

                    SysAdmin sysAdmin = new SysAdmin();
                    sysAdmin.setName(userName);
                    sysAdmin.setEmail(userEmail);
                    sysAdmin.setPhoneNo(userPhoneNo);
                    sysAdmin.setNotificationTypes(userNotifTypes);

                    sysAdminList.add(sysAdmin);
                }

                Application application = new Application();
                application.setApplicationName(appName);
                application.setLogFilePath(filePath);
                application.setUsers(sysAdminList);

                applicationList.add(application);
            }

        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        }

        System.out.println(applicationList);
        return applicationList;
    }
}
