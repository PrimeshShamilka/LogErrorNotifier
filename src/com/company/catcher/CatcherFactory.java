package com.company.catcher;

import java.util.List;

public class CatcherFactory {
    public Catcher getInstance(String severityLevel, List<String> severityList) {
        Catcher catcher = null;
        switch (severityLevel) {
            case "ERROR":
                catcher = new ErrorCatcher(severityList);
                break;
        }
        return catcher;
    }
}
