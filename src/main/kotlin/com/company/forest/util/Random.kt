package com.company.forest.util

import java.util.Random

object Random {
    fun happenWithChance(chance: Int): Boolean = Random().nextInt(101) in 1..chance
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

}