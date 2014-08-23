package com.avm.domain;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * Created with IntelliJ IDEA.
 * User: amodmulay
 * Date: 8/23/14
 * Time: 7:00 PM
 * To change this template use File | Settings | File Templates.
 */
@Component
public class GarageConfiguration {

    @Value("${garage.levels}")
    private String garageLevels;

    @Value("${garage.levels.slotsperfloor}")
    private String slotsPerLevel;

    public int getGarageLevels() {
        return Integer.parseInt(garageLevels);
    }

    public String[] getSlotsPerLevel() {

        return slotsPerLevel.split(",");
    }

    public boolean validateConfiguration() {
        if (null == garageLevels || null == slotsPerLevel)
            return Boolean.FALSE;
        else if (getSlotsPerLevel().length != getGarageLevels())
            return Boolean.FALSE;
        else
            return Boolean.TRUE;
    }
}
