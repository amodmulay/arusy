package com.avm.domain;

import java.util.Locale;

/**
 * Created with IntelliJ IDEA.
 * User: amodmulay
 * Domain defining a numberplate
 */
public class NumberPlate {

    private String number;

    /**
     * @param number Vehicle number plate value
     */
    public NumberPlate(final String number) {
        if (null != number) {
            this.number = number.trim().toUpperCase(Locale.ROOT);
        } else {
            throw new IllegalArgumentException("Number plate value cannot be null");
        }
    }

    public String getNumber() {
        return number;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        NumberPlate that = (NumberPlate) o;

        if (!number.equals(that.number)) return false;

        return true;
    }

    @Override
    public int hashCode() {
        return number.hashCode();
    }
}
