package me.sample.modelmapper;

import org.assertj.core.api.Assert;
import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.modelmapper.Converter;
import org.modelmapper.ModelMapper;
import org.modelmapper.PropertyMap;
import org.modelmapper.TypeMap;
import org.modelmapper.convention.MatchingStrategies;

import static me.sample.modelmapper.CityType.A_SMALL;
import static org.junit.Assert.assertTrue;

/**
 * Unit test for simple App.
 */
public class AppTest {
    @Test
    public void shouldAnswerWithTrue() {
        ModelMapper modelMapper = new ModelMapper();
        modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STANDARD);

        Converter<CityType, Integer> toSizeCategory = ctx ->
            ctx.getSource() == null ? -1 : sizeCategory(ctx.getSource());

        Converter<CityType, String> toRegion = ctx ->
                ctx.getSource() == null ? "N/A" : ctx.getSource().region().name().toLowerCase();

        final TypeMap<City, CityProjection> typeMap = modelMapper.createTypeMap(City.class, CityProjection.class);
        typeMap.addMappings(mapper -> {
            mapper.map(City::getName, CityProjection::setName);
            mapper.using(toSizeCategory).map(City::getCityType, CityProjection::setSizeCategory);
            mapper.using(toRegion).map(City::getCityType, CityProjection::setRegion);
        });

        modelMapper.validate();

        City paris = new City("Paris", CityType.A_LARGE);

        CityProjection cityProjection = modelMapper.map(paris, CityProjection.class);
        Assertions.assertThat(cityProjection)
                .extracting("name", "region", "sizeCategory")
                .contains("Paris", "north", 2);

        City cuzco = new City("cuzco", CityType.B_MEDIUM);

        cityProjection = modelMapper.map(cuzco, CityProjection.class);
        Assertions.assertThat(cityProjection)
                .extracting("name", "region", "sizeCategory")
                .contains("cuzco", "south", 1);
    }

    private static int sizeCategory(CityType cityType) {
        int category;
        switch (cityType) {
            case A_SMALL:
            case B_SMALL:
                category = 0;
                break;
            case A_MEDIUM:
            case B_MEDIUM:
                category = 1;
                break;
            case A_LARGE:
            case B_LARGE:
                category = 2;
                break;
            default:
                category = -1;
                break;
        }
        return category;
    }
}
