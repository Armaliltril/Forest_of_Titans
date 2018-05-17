package com.company.forest

import com.company.experimental.Core
import com.company.experimental.animal.example.StupidAnimal
import com.company.experimental.tree.example.StupidTree
import com.company.forest.util.Random
import tornadofx.*
import kotlin.concurrent.thread

object Forest {
    enum class Weather {
        SUNNY, CLOUDY, RAINY
    }
    enum class Season {
        SUMMER, AUTUMN, WINTER, SPRING
    }

    val size = 50
    
    var currentWeather: Weather
    private var currentWeatherDays = 0

    var currentSeason: Season
    private var passedDays = 0

    var currentDay: Int
    val places: ArrayList<ArrayList<Place>>
    var core: Core

    fun changeSeason() {
        currentSeason = Random.getSeason(passedDays)
    }
    fun changeWeather() {
        currentWeather = Random.getRandomWeather(currentWeatherDays)
    }
    fun changeDay() {
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
                .addTreeBehavior(StupidTree())
                .setTreeNumber(10)
                .setStartAnimalNumber(10)
                .setLimitAnimalNumber(10000)
                .build()

        currentDay = 90
        currentWeather = Weather.SUNNY
        currentSeason = Season.SUMMER

        core.create()

        places = core.places
    }
}