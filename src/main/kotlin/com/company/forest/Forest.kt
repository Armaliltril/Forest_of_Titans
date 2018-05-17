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

    //In runtime can be changed with real world time
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
        val places = arrayListOf<ArrayList<Place>>()
        for (i in 0 until size)
            places.add(makeArrayList(size, tempPlace))

        treeCenterCoordinates.forEach {
            val tree = TreeFactory.getRandomTree()
            for (i in it.first-2..it.first+2)
                for (j in it.second - 2..it.second + 2)
                    places[i][j] = PlaceWithTree(tree)
        }

        for (i in 0 until size)
            for (j in 0 until size)
                if (places[i][j] !is PlaceWithTree)
                    places[i][j] = PlaceWithoutTree()

        return places
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