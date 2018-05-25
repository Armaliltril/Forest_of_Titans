package com.company.forest.util

import com.company.forest.organisms.animal.AnimalData
import com.company.forest.Forest
import java.lang.Integer.max
import java.lang.Math.abs
import java.util.Random
import kotlin.math.roundToInt

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
    fun takeDamage(attacker: AnimalData, defender: AnimalData) {
        fun hungerCoef(animal: AnimalData) = animal.hunger.toFloat() / animal.maxHunger
        fun ageCoef(animal: AnimalData) = abs(animal.maxAge / 2 - animal.age) / (animal.maxAge.toFloat() * 2)

        val attackerTakenDamage = random.nextInt((defender.strength * hungerCoef(defender) * ageCoef(defender)).roundToInt())
        val defenderTakenDamage = random.nextInt((attacker.strength * hungerCoef(attacker) * ageCoef(attacker)).roundToInt())
        attacker.health = max(0, attacker.health - attackerTakenDamage)
        defender.health = max(0, (defender.health - defenderTakenDamage * 4))
    }
    fun tryReproduce(firstAnimal: AnimalData, secondAnimal: AnimalData): Boolean {
        if (firstAnimal.age > firstAnimal.maxAge / 4 && secondAnimal.age > secondAnimal.maxAge / 4)
            return happenWithChance(10)
        return false
    }

    private val random = Random()
}