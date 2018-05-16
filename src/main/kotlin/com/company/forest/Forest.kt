package com.company.forest

import com.company.forest.organisms.trees.TreeFactory
import com.company.forest.util.Random
import com.company.forest.util.makeArrayList

object Forest {
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

    @InProgress fun changeSeason() {

    }
    @InProgress fun changeWeather() {

    }
    @InProgress fun changeDay() {
        currentDay++
        currentDay %= 365
    }

    private val size = 50

    init {
        currentDay = 180
        currentWeather = Weather.SUNNY
        currentSeason = Season.SUMMER
        places = initPlaces()
    }
    @InProgress private fun initPlaces(): ArrayList<ArrayList<Place>> {
        val treeCenterCoordinates = Random.defineTreePlaces(size)
        val tempPlace = Place()
        val places = makeArrayList(size, makeArrayList(size, tempPlace))

        treeCenterCoordinates.forEach {
            for (i in it.first-2..it.first+2)
                for (j in it.second-2..it.second+2)
                    places[i][j] = PlaceWithTree(TreeFactory.getRandomTree())
        }

        for (i in 0 until size)
            for (j in 0 until size)
                if (places[i][j] !is PlaceWithTree)
                    places[i][j] = PlaceWithoutTree()

        return places
    }
}