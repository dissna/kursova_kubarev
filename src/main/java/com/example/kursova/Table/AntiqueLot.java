package com.example.kursova.Table;

import java.sql.Time;
import java.util.Date;

public class AntiqueLot {
    private int id;
    private Date date;
    private Time time;
    private int organizer_id;
    private int purchaser_id;
    private int lot_id;
    private int antique_id;

    public AntiqueLot() {}

    public AntiqueLot(int id, Date date, Time time, int organizer_id, int purchaser_id, int lot_id, int antique_id) {
        this.id = id;
        this.date = date;
        this.time = time;
        this.organizer_id = organizer_id;
        this.purchaser_id = purchaser_id;
        this.lot_id = lot_id;
        this.antique_id = antique_id;
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

    public Time getTime() {
        return time;
    }

    public void setTime(Time time) {
        this.time = time;
    }

    public int getOrganizer_id() {
        return organizer_id;
    }

    public void setOrganizer_id(int organizer_id) {
        this.organizer_id = organizer_id;
    }

    public int getPurchaser_id() {
        return purchaser_id;
    }

    public void setPurchaser_id(int purchaser_id) {
        this.purchaser_id = purchaser_id;
    }

    public int getLot_id() {
        return lot_id;
    }

    public void setLot_id(int lot_id) {
        this.lot_id = lot_id;
    }

    public int getAntique_id() {
        return antique_id;
    }

    public void setAntique_id(int antique_id) {
        this.antique_id = antique_id;
    }
}
