package com.example.kursova.Table;

import java.util.Date;

public class Purchaser {
    private int id;
    private String full_name;
    private String sex;
    private String phone;
    private Date birthday;
    private Date registration_date;

    public Purchaser() {}

    public Purchaser(int id, String full_name, String sex, String phone, Date birthday, Date registration_date) {
        this.id = id;
        this.full_name = full_name;
        this.sex = sex;
        this.phone = phone;
        this.birthday = birthday;
        this.registration_date = registration_date;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFull_name() {
        return full_name;
    }

    public void setFull_name(String full_name) {
        this.full_name = full_name;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public Date getRegistration_date() {
        return registration_date;
    }

    public void setRegistration_date(Date registration_date) {
        this.registration_date = registration_date;
    }
}
