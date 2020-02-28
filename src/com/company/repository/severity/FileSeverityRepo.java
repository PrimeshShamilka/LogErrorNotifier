package com.company.repository.severity;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class FileSeverityRepo implements SeverityRepo {

    private String filePath;

    public FileSeverityRepo(String filePath){
        this.filePath = filePath;
    }

    @Override
    public List<String> getErrorLevels() {
        List<String> severityList = new ArrayList<>();

        try {
            List<String> data = Files.readAllLines(Paths.get(filePath));

            List<String> tempList = new ArrayList<>();
            data.forEach(row -> {
                tempList.add(row);
            });
            for(int i=0;(i<tempList.size()-1);i++){
                severityList.add(tempList.get(i).split(" ")[1]);
            }

        } catch (IOException e) {
            e.printStackTrace(); //TODO: CHANGE THIS
        }

        return severityList;
    }
}
