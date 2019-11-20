package me.sample.modelmapper;

public enum CityType {

    A_SMALL(1000, Region.NORTH),
    A_MEDIUM(2000, Region.NORTH),
    A_LARGE(100_000, Region.NORTH),

    B_SMALL(100, Region.SOUTH),
    B_MEDIUM(200, Region.SOUTH),
    B_LARGE(10_000, Region.SOUTH),
    UNKNOWN(0, Region.NORTH);

    private final int population;
    private final Region region;

    CityType(int population, Region region) {
        this.population = population;
        this.region = region;
    }

    public int population() {
        return population;
    }

    public Region region() {
        return region;
    }

    public static CityType from(int population, Region region) {
        CityType cityType = UNKNOWN;
        switch (region) {
            case NORTH:
            case WEST:
                if (population < 1000) {
                    cityType = A_SMALL;
                } else if (population < 2000) {
                    cityType = A_MEDIUM;
                } else {
                    cityType = A_LARGE;
                }
                break;
            case SOUTH:
            case EAST:
                if (population < 1000) {
                    cityType = B_SMALL;
                } else if (population < 2000) {
                    cityType = B_MEDIUM;
                } else {
                    cityType = B_LARGE;
                }
                break;
        }
        return cityType;
    }
}
