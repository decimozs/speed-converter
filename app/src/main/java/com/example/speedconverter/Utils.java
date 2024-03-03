package com.example.speedconverter;

public class Utils {
    public static double computation(double input, String unit1, String unit2) {
        double result = 0;

        if (unit1.equals("km/h") && unit2.equals("m/s")) {
            result = Formula.kmhToMs(input);
        } else if (unit1.equals("km/h") && unit2.equals("mph")) {
            result = Formula.kmhToMph(input);
        } else if (unit1.equals("m/s") && unit2.equals("mph")) {
            result = Formula.msToMph(input);
        } else if (unit1.equals("m/s") && unit2.equals("km/h")) {
            result = Formula.msToKmh(input);
        } else if (unit1.equals("mph") && unit2.equals("km/h")) {
            result = Formula.mphToKmh(input);
        } else if (unit1.equals("mph") && unit2.equals("m/s")) {
            result = Formula.mphToMs(input);
        }

        return result;
    }

    public static String unitsTextConversion(String unit) {
        String text = "";

        switch(unit) {
            case "km/h":
                text = "Kilometer per hour";
                break;
            case "m/s":
                text = "Metre per second";
                break;
            case "mph":
                text = "Miles per hour";
                break;
            default:
                break;
        }

        return text;
    }

    public static String getConversionResult(String unit1, String unit2) {
        String text = "";

        if ((unit1.equals("km/h") && unit2.equals("m/s")) ||
                (unit1.equals("km/h") && unit2.equals("mph")) ||
                (unit1.equals("m/s") && unit2.equals("mph")) ||
                (unit1.equals("m/s") && unit2.equals("km/h")) ||
                (unit1.equals("mph") && unit2.equals("km/h")) ||
                (unit1.equals("mph") && unit2.equals("m/s"))) {

            MainActivity.resultHeader.setText("Successfully Converted");
            text = unit1 + " to " + unit2;
        } else {
            MainActivity.resultHeader.setText("Failed to convert");
            text = unit1 + " to " + unit2;
        }

        return text;
    }
}
