package com.example.kursova.Table;

public class OrganizerLotData {
    private String full_name;
    private int lot_count;

    public OrganizerLotData(String full_name, int lot_count) {
        this.full_name = full_name;
        this.lot_count = lot_count;
    }

    public String getFull_name() {
        return full_name;
    }

    public void setFull_name(String full_name) {
        this.full_name = full_name;
    }

    public int getLot_count() {
        return lot_count;
    }

    public void setLot_count(int lot_count) {
        this.lot_count = lot_count;
    }
}
