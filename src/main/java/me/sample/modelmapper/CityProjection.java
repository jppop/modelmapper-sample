package me.sample.modelmapper;

public class CityProjection {
    private String name;
    private String region;
    private int sizeCategory;

    public CityProjection() {
    }

    public CityProjection(String name, String region, int sizeCategory) {
        this.name = name;
        this.region = region;
        this.sizeCategory = sizeCategory;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public int getSizeCategory() {
        return sizeCategory;
    }

    public void setSizeCategory(int sizeCategory) {
        this.sizeCategory = sizeCategory;
    }

    @Override
    public String toString() {
        return "CityProjection{" +
                "name='" + name + '\'' +
                ", region='" + region + '\'' +
                ", sizeCategory=" + sizeCategory +
                '}';
    }
}
