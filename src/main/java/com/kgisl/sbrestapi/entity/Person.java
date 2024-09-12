package com.kgisl.sbrestapi.entity;

 
public class Person {
    int id;
    String uname;
    String email;

    public Person(String email, int id, String uname) {
        this.email = email;
        this.id = id;
        this.uname = uname;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUname() {
        return uname;
    }

    public void setUname(String uname) {
        this.uname = uname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}