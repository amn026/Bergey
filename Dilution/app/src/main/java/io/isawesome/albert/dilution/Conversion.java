package io.isawesome.albert.dilution;

/**
 * Created by MarkDiez on 10/1/16.
 */

public class Conversion {
    /**
     * Converts a liquid measurement to Liters
     * @param currentMetric - "from"
     * @param value - current amount
     * @return
     */
    public static double convertToBase(Unit currentMetric, double value) {
        double newValue = 0;

        switch(currentMetric) {
            case MOLE:
            case LITER:
                newValue = value;
                break;
            case MILLI:
                newValue = value / 1000;
                break;
            case MICRO:
                newValue = value / 1000000;
                break;
            case NANO:
                newValue = value / 1000000000;
                break;
        }

        return newValue;
    }

    /**
     * Converts a liquid measurement to milli_
     * @param currentMetric - "from"
     * @param value - current amount
     * @return
     */
    public static double convertToMilli(Unit currentMetric, double value) {
        double newValue = 0;

        switch(currentMetric) {
            case MOLE:
            case LITER:
                newValue = value * 1000;
                break;
            case MILLI:
                newValue = value;
                break;
            case MICRO:
                newValue = value / 1000;
                break;
            case NANO:
                newValue = value / 1000000;
                break;
        }
        return newValue;
    }

    public static double convertToMicro(Unit currentMetric, double value) {
        double newValue = 0;

        switch(currentMetric) {
            case MOLE:
            case LITER:
                newValue = value * 1000000;
                break;
            case MILLI:
                newValue = value * 1000;
                break;
            case MICRO:
                newValue = value;
                break;
            case NANO:
                newValue = value / 1000;
                break;
        }
        return newValue;
    }

    public static double convertToNano(Unit currentMetric, double value) {
        double newValue = 0;

        switch(currentMetric) {
            case MOLE:
            case LITER:
                newValue = value * 1000000000;
                break;
            case MILLI:
                newValue = value * 1000000;
                break;
            case MICRO:
                newValue = value * 1000;
                break;
            case NANO:
                newValue = value;
                break;
        }
        return newValue;
    }

    public static Unit getUnit(int pos) {
        // Position is based on the order in strings array from 0
        switch (pos) {
            case 0:
                return Unit.LITER; // Or mole, doesn't matter
            case 1:
                return Unit.MILLI;
            case 2:
                return Unit.MICRO;
            case 3:
                return Unit.NANO;
            default:
                break;
        }

        // Should never reach this
        return null;
    }

    public static double convertTo(Unit wantedUnit, double value) {
        Unit currentUnit = Unit.LITER;
        switch(wantedUnit) {
            case MOLE:
            case LITER:
                return convertToBase(currentUnit, value);
            case MILLI:
                return convertToMilli(currentUnit, value);
            case MICRO:
                return convertToMicro(currentUnit, value);
            case NANO:
                return convertToNano(currentUnit, value);
            default:
                return value;
        }
    }
}
