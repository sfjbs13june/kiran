package com.kiran.app.model;

import org.springframework.stereotype.Component;

@Component
public class Hospital {

    //    hospitalname
//    address
//    id
    String hname;
    String address;
    int id;

    public Hospital() {
    }

    public Hospital(String hname, String address, int id) {
        this.hname = hname;
        this.address = address;
        this.id = id;
    }

    public String getHname() {
        return hname;
    }

    public String getAddress() {
        return address;
    }

    public int getId() {
        return id;
    }

    public void setHname(String hname) {
        this.hname = hname;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setId(int id) {
        this.id = id;
    }


}