package com.example.slinder;

public class User {

    public String group;
    public String startdate;
    public String enddate;
    public String list[];

    public User(){

    }

    public User(String username){
        this.group = username;
    }

    public User(String s, String e){
        this.startdate = s;
        this.enddate = e;
    }

    public User(String s, String e, String str){
        this.startdate = s;
        this.enddate = e;
        this.group = str;
    }
}
