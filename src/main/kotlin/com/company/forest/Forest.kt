package com.company.forest

import com.company.forest.organisms.Core
import com.company.forest.organisms.animal.types.*
import com.company.forest.organisms.tree.types.*
import com.company.forest.util.Random

object Forest {
    enum class Weather {
        SUNNY, CLOUDY, RAINY
    }
    enum class Season {
        SUMMER, AUTUMN, WINTER, SPRING
    }

    const val size = 60
    
    var currentWeather: Weather
    private var currentWeatherLasts = 0

    var currentSeason: Season
    private var passedDays = 0

    var currentDay: Int

    val places: ArrayList<ArrayList<Place>>
    private var core: Core

    private fun changeSeason() {
        currentSeason = Random.getSeason(passedDays)
    }
    private fun changeWeather() {
        if (Random.isWeatherChanging(currentWeatherLasts)) {
            currentWeather = Random.getRandomWeather()
            currentWeatherLasts = 0
        }
        else currentWeatherLasts++
    }
    private fun changeDay() {
        currentDay++
        currentDay %= 365
    }

    fun tick() {
        core.tick()
        if (core.worldTime % 50 == 49) {
            changeDay()
            changeWeather()
            changeSeason()
        }
    }

    init {
        core = Core.Builder()
                .addAnimalBehavior(StupidAnimal())
                .addAnimalBehavior(Badger())
                .addAnimalBehavior(Chipmunk())
                .addAnimalBehavior(FlyingSquirrel())
                .addAnimalBehavior(Squirrel())
                .addAnimalBehavior(Vulture())
                .addAnimalBehavior(Wolf())
                .addAnimalBehavior(Woodpecker())
                .addTreeBehavior(Hazel())
                .addTreeBehavior(Birch())
                .addTreeBehavior(Spruce())
                .addTreeBehavior(Oak())
                .addTreeBehavior(Maple())
                .addTreeBehavior(Pine())
                .setTreeNumber(30)
                .setStartAnimalNumber(80)
                .setLimitAnimalNumber(10000)
                .build()

        core.createOrganisms()

        places = core.places

        currentDay = 90
        currentWeather = Weather.SUNNY
        currentSeason = Season.SUMMER
    }
}