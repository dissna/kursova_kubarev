package com.example.kursova.Table;

public class AntiquityTypeData {
    private String material;
    private int manufacture_year;
    private String style;
    private int antiquity_count;

    public AntiquityTypeData(String material, int manufacture_year, String style, int antiquity_count) {
        this.material = material;
        this.manufacture_year = manufacture_year;
        this.style = style;
        this.antiquity_count = antiquity_count;
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

    public int getAntiquity_count() {
        return antiquity_count;
    }

    public void setAntiquity_count(int antiquity_count) {
        this.antiquity_count = antiquity_count;
    }
}
