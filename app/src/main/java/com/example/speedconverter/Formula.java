package com.example.speedconverter;

public class Formula {
    public static double kmhToMs(double speedKmh) {
        return speedKmh * 1000 / 3600;
    }

    public static double kmhToMph(double speedKmh) {
        return speedKmh / 1.609344;
    }

    public static double msToKmh(double speedMs) {
        return speedMs * 3600 / 1000;
    }

    public static double msToMph(double speedMs) {
        return speedMs * 3600 / 1609.344;
    }

    public static double mphToKmh(double speedMph) {
        return speedMph * 1.609344;
    }

    public static double mphToMs(double speedMph) {
        return speedMph * 0.44704;
    }

}
