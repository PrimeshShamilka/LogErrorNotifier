package com.company.catcher;

import java.util.ArrayList;
import java.util.List;

public class ErrorCatcher implements Catcher{

    private List<String> severityLevels;

    public ErrorCatcher(List<String> severityLevel){
        this.severityLevels = severityLevel;
    }
    
    @Override
    public List<String> catchFaults(){
        // returns a list of ERROR severity level
        List<String> errors = new ArrayList<>();
        severityLevels.forEach(level -> {
            if(level.equals("ERROR")){
                errors.add(level);
            }
        });
        return errors;
    }

}
