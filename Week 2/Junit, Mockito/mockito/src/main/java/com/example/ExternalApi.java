package com.example;

public interface ExternalApi {
    String getData();
    String getDataById(int id);
    void log(String message);
}
