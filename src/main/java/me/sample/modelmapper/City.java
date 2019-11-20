package me.sample.modelmapper;

public class City {
    private String name;
    private CityType cityType;

    public City() {
    }

    public City(String name, CityType cityType) {
        this.name = name;
        this.cityType = cityType;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public CityType getCityType() {
        return cityType;
    }

    public void setCityType(CityType cityType) {
        this.cityType = cityType;
    }

    @Override
    public String toString() {
        return "City{" +
                "name='" + name + '\'' +
                ", cityType=" + cityType +
                '}';
    }
}
