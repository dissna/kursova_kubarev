package com.example.kursova.Table;

import java.util.Date;

public class Organizer {
    private int id;
    private String full_name;
    private String sex;
    private String phone;
    private Date birthday;
    private Date employment_date;
    private Date dismissal_date;

    public Organizer() {}

    public Organizer(int id, String full_name, String sex, String phone, Date birthday, Date employment_date, Date dismissal_date) {
        this.id = id;
        this.full_name = full_name;
        this.sex = sex;
        this.phone = phone;
        this.birthday = birthday;
        this.employment_date = employment_date;
        this.dismissal_date = dismissal_date;
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

    public Date getEmployment_date() {
        return employment_date;
    }

    public void setEmployment_date(Date employment_date) {
        this.employment_date = employment_date;
    }

    public Date getDismissal_date() {
        return dismissal_date;
    }

    public void setDismissal_date(Date dismissal_date) {
        this.dismissal_date = dismissal_date;
    }
}
