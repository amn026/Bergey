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
    public static double convertToLiter(LiquidUnit currentMetric, double value) {
        double newValue = 0;

        switch(currentMetric) {
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
    public static double convertToMilli(LiquidUnit currentMetric, double value) {
        double newValue = 0;

        switch(currentMetric) {
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

    public static double convertToMicro(LiquidUnit currentMetric, double value) {
        double newValue = 0;

        switch(currentMetric) {
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

    public static double convertToNano(LiquidUnit currentMetric, double value) {
        double newValue = 0;

        switch(currentMetric) {
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
}
