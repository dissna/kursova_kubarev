package com.example.kursova.Table;

public class Type {
    private int id;
    private String material;
    private int manufacture_year;
    private String style;

    public Type() {}

    public Type(int id, String material, int manufacture_year, String style) {
        this.id = id;
        this.material = material;
        this.manufacture_year = manufacture_year;
        this.style = style;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMaterial() {
        return material;
    }

    public void setMaterial(String material) {
        this.material = material;
    }

    public int getManufacture_year() {
        return manufacture_year;
    }

    public void setManufacture_year(int manufacture_year) {
        this.manufacture_year = manufacture_year;
    }

    public String getStyle() {
        return style;
    }

    public void setStyle(String style) {
        this.style = style;
    }
}
