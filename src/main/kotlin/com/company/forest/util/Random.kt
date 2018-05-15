package com.company.forest.util

import java.util.Random

object Random {
    fun happenWithChance(chance: Int): Boolean = if(Random().nextInt(100) in 1..chance) true else false
    fun defineTreePlaces(size: Int): Array<Array<Boolean>> {
        val mask = Array(size, { Array(size, { false }) })
        fun isAvailable(i: Int, j: Int): Boolean {
            //Not optimal
            for (row in 0 until size)
                for (col in 0 until size)
                    if (    mask[row][col] == true && //there is a tree
                            row in i-2..i+2 && col in j-2..j+2 && // around
                            row in 2..size-2 && col in 2..size-2) // and far enough of borders
                        return false
            return true
        }
        for (i in 0 until size) {
            for (j in 0 until size) {
                if (isAvailable(i, j) && happenWithChance(1))
                    mask[i][j] = true
            }
        }
        return mask
    }

}