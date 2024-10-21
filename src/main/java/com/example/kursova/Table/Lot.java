package com.example.kursova.Table;

import java.util.Date;

public class Lot {
    private int id;
    private Date start_date;
    private int start_cost;
    private Date end_date;

    public Lot() {}

    public Lot(int id, Date start_date, int start_cost, Date end_date) {
        this.id = id;
        this.start_date = start_date;
        this.start_cost = start_cost;
        this.end_date = end_date;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getStart_date() {
        return start_date;
    }

    public void setStart_date(Date start_date) {
        this.start_date = start_date;
    }

    public int getStart_cost() {
        return start_cost;
    }

    public void setStart_cost(int start_cost) {
        this.start_cost = start_cost;
    }

    public Date getEnd_date() {
        return end_date;
    }

    public void setEnd_date(Date end_date) {
        this.end_date = end_date;
    }
}
