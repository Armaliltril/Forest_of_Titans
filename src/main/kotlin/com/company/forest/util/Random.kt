package com.company.forest.util

import java.util.Random

object Random {
    fun happenWithChance(chance: Int): Boolean = if(Random().nextInt(100) in 1..chance) true else false
    fun defineTreePlaces(size: Int): ArrayList<Pair<Int, Int>> {
        val mask = Array(size, { Array(size, { false }) })
        val treeCenterCoordinates = arrayListOf<Pair<Int, Int>>()
        fun isAvailable(i: Int, j: Int): Boolean {
            for (row in i-2..i+2)
                for (col in j-2..j+2)
                    if (row in 2..size-2 && col in 2..size-2 // within the borders
                            && mask[row][col] == true) // and there is a tree
                        return false
            return true
        }

        for (i in 0 until size) {
            for (j in 0 until size) {
                if (isAvailable(i, j) && happenWithChance(1)) {
                    mask[i][j] = true
                    treeCenterCoordinates.add(Pair(i, j))
                }
            }
        }

        return treeCenterCoordinates
    }

}