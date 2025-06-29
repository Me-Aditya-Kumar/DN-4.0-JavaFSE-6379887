package com.example;

public class MyService {
    private ExternalApi api;

    public MyService(ExternalApi api) {
        this.api = api;
    }

    public String fetchData() {
        return api.getData();
    }

    public String fetchDataById(int id) {
        return api.getDataById(id);
    }
    public void logMessage(String message) {
        api.log(message);
    }
    public void process() {
        api.log("Start");
        api.getData();
        api.log("End");
    }
    public void safeLog(String message) {
    api.log(message);
}
}
