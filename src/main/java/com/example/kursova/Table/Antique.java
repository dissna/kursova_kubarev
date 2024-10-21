package com.example.kursova.Table;

public class Antique {
    private int id;
    private String description;
    private String status;
    private int rating;
    private boolean photo; // SMALLINT as boolean
    private int position_type;

    public Antique() {}

    public Antique(int id, String description, String status, int rating, boolean photo, int position_type) {
        this.id = id;
        this.description = description;
        this.status = status;
        this.rating = rating;
        this.photo = photo;
        this.position_type = position_type;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public boolean isPhoto() {
        return photo;
    }

    public void setPhoto(boolean photo) {
        this.photo = photo;
    }

    public int getPosition_type() {
        return position_type;
    }

    public void setPosition_type(int position_type) {
        this.position_type = position_type;
    }
}
