package com.avm.domain;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * Created with IntelliJ IDEA.
 * User: amodmulay
 * Garage Configuration object used to load the garage configuration from the arusy-config.properties file.
 */
@Component
public class GarageConfiguration {

    @Value("${garage.levels}")
    private String garageLevels;

    @Value("${garage.levels.slotsperfloor}")
    private String slotsPerLevel;

    @Value("${garage.charge.motorcar}")
    private String chargeForCar;

    @Value("${garage.charge.motorcycle}")
    private String chargeForMotorcycle;

    public int getGarageLevels() {
        return Integer.parseInt(garageLevels);
    }

    public String[] getSlotsPerLevel() {

        return slotsPerLevel.split(",");
    }

    public String getChargeForCar() {
        return chargeForCar;
    }

    public String getChargeForMotorcycle() {
        return chargeForMotorcycle;
    }

    public void validateConfiguration() {
        if (null == garageLevels || null == slotsPerLevel)
            throw new IllegalStateException("Garage cannot exist without parking slots. Check config file");
        else if (getSlotsPerLevel().length != getGarageLevels())
            throw new IllegalStateException("Check config file slot count");
    }
}
