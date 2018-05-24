package com.company.experimental.tree

import com.company.forest.Forest
import java.lang.Integer.min

data class TreeFood(var onCrown: Int, var onTrump: Int, var onRoots: Int,
                    var maxOnCrown: Int, var maxOnTrump: Int, var maxOnRoots: Int) {
    enum class Level {
        CROWN {
            override fun getSeasonCoef() = when(Forest.currentWeather) {
                Forest.Weather.SUNNY -> 2
                Forest.Weather.RAINY -> 3
                Forest.Weather.CLOUDY -> 1
            }

            override fun getWeatherCoef() = when(Forest.currentSeason) {
                Forest.Season.SPRING -> 3
                Forest.Season.WINTER -> 1
                Forest.Season.SUMMER -> 4
                Forest.Season.AUTUMN -> 2
            }
        },
        TRUMP {
            override fun getSeasonCoef() = when(Forest.currentWeather) {
                Forest.Weather.SUNNY -> 1
                Forest.Weather.RAINY -> 3
                Forest.Weather.CLOUDY -> 2
            }

            override fun getWeatherCoef() = when(Forest.currentSeason) {
                Forest.Season.SPRING -> 4
                Forest.Season.WINTER -> 1
                Forest.Season.SUMMER -> 2
                Forest.Season.AUTUMN -> 3
            }
        },
        ROOTS {
            override fun getSeasonCoef() = when(Forest.currentWeather) {
                Forest.Weather.SUNNY -> 2
                Forest.Weather.RAINY -> 1
                Forest.Weather.CLOUDY -> 3
            }

            override fun getWeatherCoef() = when(Forest.currentSeason) {
                Forest.Season.SPRING -> 1
                Forest.Season.WINTER -> 2
                Forest.Season.SUMMER -> 3
                Forest.Season.AUTUMN -> 4
            }
        };

        abstract fun getWeatherCoef(): Int
        abstract fun getSeasonCoef(): Int
    }

    fun produce(foodPerTick: Int) {
        onCrown = min(maxOnCrown, onCrown + foodPerTick * Level.CROWN.getSeasonCoef() * Level.CROWN.getWeatherCoef())
        onTrump = min(maxOnTrump, onTrump + foodPerTick * Level.ROOTS.getSeasonCoef() * Level.TRUMP.getWeatherCoef())
        onRoots = min(maxOnRoots, onRoots + foodPerTick * Level.ROOTS.getSeasonCoef() * Level.ROOTS.getWeatherCoef())
    }
}