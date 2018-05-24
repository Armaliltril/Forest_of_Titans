package com.company.forest.util

import com.company.forest.Forest
import com.company.forest.InProgress
import java.util.Random

object Random {
    fun happenWithChance(chance: Int): Boolean = random.nextInt(101) in 1..chance
    fun defineTreePlaces(size: Int): ArrayList<Pair<Int, Int>> {
        val mask = Array(size, { Array(size, { false }) })
        val treeCenterCoordinates = arrayListOf<Pair<Int, Int>>()
        fun isAvailable(i: Int, j: Int): Boolean {
            for (row in i-2..i+2)
                for (col in j-2..j+2)
                    if (mask[row][col]) // there is a tree
                        return false
            return true
        }

        for (i in 2 until size - 2) {
            for (j in 2 until size - 2) {
                if (isAvailable(i, j) && happenWithChance(1)) {
                    mask[i][j] = true
                    treeCenterCoordinates.add(Pair(i, j))
                }
            }
        }

        return treeCenterCoordinates
    }

    fun isWeatherChanging(currentWeatherLasts: Int): Boolean {
        return happenWithChance(currentWeatherLasts * 5)
    }
    fun getRandomWeather(): Forest.Weather {
        return when(random.nextInt(3)) {
            0 -> Forest.Weather.SUNNY
            1 -> Forest.Weather.CLOUDY
            2 -> Forest.Weather.RAINY
            else -> throw RuntimeException("Not correct random in getRandomWeather")
        }
    }
    fun getSeason(passedDays: Int): Forest.Season {
        return when(passedDays) {
            in 0..90 -> Forest.Season.SUMMER
            in 91..180 -> Forest.Season.AUTUMN
            in 181..270 -> Forest.Season.WINTER
            in 270..365 -> Forest.Season.SPRING
            else -> throw RuntimeException("Wrong number of days in getSeason")
        }
    }

    private val random = Random()
}