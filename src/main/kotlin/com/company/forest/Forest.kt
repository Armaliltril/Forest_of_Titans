package com.company.forest

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
    val places: Array<Array<Place>>

    @InProgress fun changeSeason() {

    }
    @InProgress fun changeWeather() {

    }
    @InProgress fun changeDay() {
        currentDay++
        currentDay %= 365
    }

    init {
        currentDay = 180
        currentWeather = Weather.SUNNY
        currentSeason = Season.SUMMER
        places = Array(10, { Array(10, { Place() }) }) //TODO() Need proper random initialization
    }
}