package com.example.kursova.Table;

import java.util.Date;

public class Receipt {
    private int id;
    private Date date;
    private int summ;
    private int organizer_id;

    public Receipt() {}

    public Receipt(int id, Date date, int summ, int organizer_id) {
        this.id = id;
        this.date = date;
        this.summ = summ;
        this.organizer_id = organizer_id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public int getSumm() {
        return summ;
    }

    public void setSumm(int summ) {
        this.summ = summ;
    }

    public int getOrganizer_id() {
        return organizer_id;
    }

    public void setOrganizer_id(int organizer_id) {
        this.organizer_id = organizer_id;
    }
}
