package com.example.aircalendar;

public class User {

    public String group;
    public String startdate;
    public String enddate;
    public String name;
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

    public String setStartdate(){
        return startdate;
    }
    public void setStartdate(String startdate){
        this.startdate = startdate;
    }
    public String setEnddate(){
        return enddate;
    }
    public void setEnddate(String enddate){
        this.enddate = enddate;
    }
    public String setName(){
        return name;
    }
    public void setName(String name){
        this.name = name;
    }
}
