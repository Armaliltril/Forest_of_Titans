package com.company.forest

import com.company.experimental.Core
import com.company.experimental.animal.example.StupidAnimal
import com.company.experimental.tree.example.StupidTree
import javafx.animation.AnimationTimer
import javafx.scene.shape.Rectangle
import tornadofx.*
import kotlin.concurrent.thread

object Forest {
    var timer : AnimationTimer? = null

    enum class Weather {
        SUNNY, CLOUDY, RAINY
    }
    enum class Season {
        SUMMER, AUTUMN, WINTER, SPRING
    }
    
    var currentWeather: Weather
    var currentSeason: Season
    var currentDay: Int
    val places: ArrayList<ArrayList<Place>>
    val colors: ArrayList<ArrayList<Rectangle>> = ArrayList()

    var core: Core

    //In runtime can be changed with real world time
    @InProgress fun changeSeason() {

    }
    @InProgress fun changeWeather() {

    }
    @InProgress fun changeDay() {
        currentDay++
        currentDay %= 365
    }

    public val size = 50

    init {
        core = Core.Builder()
                .addAnimalBehavior(StupidAnimal())
                .addTreeBehavior(StupidTree())
                .setTreeNumber(10)
                .setStartAnimalNumber(10)
                .setLimitAnimalNumber(10000)
                .build()

        currentDay = 180
        currentWeather = Weather.SUNNY
        currentSeason = Season.SUMMER
        places = core.places

//        runAsync {
//            core.run()
//        }

    }

    //FOR TESTING
    fun printPlaces(places: ArrayList<ArrayList<Place>>) {
        var row = "----------------------------------------------------\n"
        places.forEach { it.forEach { if (it is PlaceWithoutTree) row += "p"
                        else if (it is PlaceWithTree) row += "t"
                        else row += "0"};
            row += "\n" }
        print(row + "\n")
    }
}