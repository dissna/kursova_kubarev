package com.example.kursova.Table;

import java.util.Date;

public class MostExpensiveLotData {
    private String material;
    private String  style;
    private int manufacture_year;
    private int id;
    private int start_cost;
    private Date start_date;
    private Date end_date;

    public MostExpensiveLotData(String material, int manufacture_year, String style, int id, int start_cost, Date start_date, Date end_date) {
        this.material = material;
        this.style = style;
        this.manufacture_year = manufacture_year;
        this.id = id;
        this.start_cost = start_cost;
        this.start_date = start_date;
        this.end_date = end_date;
    }

    public String getMaterial() {
        return material;
    }

    public void setMaterial(String material) {
        this.material = material;
    }

    public String getStyle() {
        return style;
    }

    public void setStyle(String style) {
        this.style = style;
    }

    public int getManufacture_year() {
        return manufacture_year;
    }

    public void setManufacture_year(int manufacture_year) {
        this.manufacture_year = manufacture_year;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getStart_cost() {
        return start_cost;
    }

    public void setStart_cost(int start_cost) {
        this.start_cost = start_cost;
    }

    public Date getStart_date() {
        return start_date;
    }

    public void setStart_date(Date start_date) {
        this.start_date = start_date;
    }

    public Date getEnd_date() {
        return end_date;
    }

    public void setEnd_date(Date end_date) {
        this.end_date = end_date;
    }
}
