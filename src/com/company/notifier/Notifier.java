package com.company.notifier;

import com.company.Application;
import com.company.SysAdmin;

public interface Notifier {
    void notifyUser(SysAdmin user, Application application);
}
