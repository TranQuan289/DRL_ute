package com.example.android.drl.User;

public class User {
    String level,name,permission;
    long msv;
    int sum;

    public String getPermission() {
        return permission;
    }

    public void setPermission(String permission) {
        this.permission = permission;
    }

    public User(){

    }
    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getMsv() {
        return msv;
    }

    public void setMsv(long msv) {
        this.msv = msv;
    }

    public int getSum() {
        return sum;
    }

    public void setSum(int sum) {
        this.sum = sum;
    }

    public User(String level, String name, long msv, int sum) {
        this.level = level;
        this.name = name;
        this.msv = msv;
        this.sum = sum;
    }
}

