package model;

import java.util.Random;

public enum WeatherEnum {
    NORMAL, RAINY, SUNNY, STORMY, METEOR_SHOWER;

    private static Random random = new Random();
    public static  WeatherEnum getRandomWeather(){

        return WeatherEnum.values()[random.nextInt(0, WeatherEnum.values().length)];
    }
}

/**
 * RAINY: + for water, - for electricity
 * SUNNY: + for fire, - for water
 * STORMY: + for electricity, - for earth
 * METEOR_SHOWER: + for earth, - for fire
 */
