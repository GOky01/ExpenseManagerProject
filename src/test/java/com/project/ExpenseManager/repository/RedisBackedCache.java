package com.project.ExpenseManager.repository;

public class RedisBackedCache {
    private String  test;
    private String  example;

    public RedisBackedCache(String address, Integer port) {

    }

    public void put(String test, String example) {
        this.test=test;
        this.example=example;
    }

    public String get(String test) {
        if(test == this.test)
            return this.example;
        else return null;

    }
}
