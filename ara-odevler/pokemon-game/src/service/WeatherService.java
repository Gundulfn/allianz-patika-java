package service;

import model.Pokemon;
import model.TypeEnum;
import model.WeatherEnum;

public class WeatherService {
    public int getWeatherEffectOnDamage(WeatherEnum weatherEnum, Pokemon pokemon) {
        if (weatherEnum.equals(WeatherEnum.RAINY)) {
            if (pokemon.getType().equals(TypeEnum.WATER)) {
                System.out.println("Rains buffed Water Pokemon's attack");
                return 3;
            } else if (pokemon.getType().equals(TypeEnum.ELECTRICITY)) {
                System.out.println("Electricity Pokemon's attack hurts more on rainy day");
                return 2;
            }
        } else if (weatherEnum.equals(WeatherEnum.METEOR_SHOWER)) {
            if (pokemon.getType().equals(TypeEnum.EARTH)) {
                System.out.println("Meteor shower gives power to Earth Pokemon");
                return 3;
            } else if (pokemon.getType().equals(TypeEnum.FIRE)) {
                System.out.println("Rocks falling on Fire Pokemon extinguishes its fires some");
                return -2;
            }
        } else if (weatherEnum.equals(WeatherEnum.SUNNY)) {
            if (pokemon.getType().equals(TypeEnum.FIRE)) {
                System.out.println("Fire Pokemon's flames grow on sunny day");
                return 4;
            }
        } else if (weatherEnum.equals(WeatherEnum.STORMY)) {
            if (pokemon.getType().equals(TypeEnum.ELECTRICITY)) {
                System.out.println("Thunders charges up electricity pokemon");
                return 5;
            } else if (pokemon.getType().equals(TypeEnum.EARTH)) {
                System.out.println("Earth pokemon gets distracted by storms");
                return -2;
            }
        }

        return 0;
    }

    /**
     * When electricity type pokemon attacks on rainy weather, it's attack shocks itself
     * When water type pokemon attacks on stays on sunny weather, it gets evaporated
     */
    public void affectPokemonByWeather(WeatherEnum weatherEnum, Pokemon pokemon, boolean isAttacking) {
        if (weatherEnum.equals(WeatherEnum.RAINY)) {
            if (pokemon.getType().equals(TypeEnum.ELECTRICITY) && isAttacking) {
                pokemon.setHealth(pokemon.getHealth() - 2);
                System.out.println("Electricity pokemon shocks itself");
            }
        } else if (weatherEnum.equals(WeatherEnum.SUNNY)) {
            if (pokemon.getType().equals(TypeEnum.WATER)) {
                pokemon.setHealth(pokemon.getHealth() - 1);
                System.out.println("Water pokemon gets evaporated");
            }
        }
    }
}
