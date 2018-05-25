package com.company.forest.util

import com.company.forest.organisms.animal.AnimalType
import com.company.forest.organisms.tree.TreeData
import com.company.forest.organisms.tree.TreeType
import com.company.forest.Forest
import com.company.forest.PlaceWithTree
import com.company.forest.PlaceWithoutTree

object Observer {
    fun countAnimals(type: AnimalType): Int {
        var counter = 0
        Forest.places.forEach { it.forEach { if (it is PlaceWithoutTree && it.animal?.behavior?.getType() == type) counter++} }
        return counter
    }
    fun countTrees(type: TreeType): Int {
        val uniqueTrees = mutableSetOf<TreeData>()
        Forest.places.forEach { it.forEach { if (it is PlaceWithTree && it.tree.behavior.getType() == type) uniqueTrees.add(it.tree)} }
        return uniqueTrees.size
    }
    fun countAllAnimals(): Int {
        var counter = 0
        Forest.places.forEach { it.forEach { if (it is PlaceWithoutTree && it.animal != null) counter++ } }
        return counter
    }
    fun countAllTrees(): Int {
        val uniqueTrees = mutableSetOf<TreeData>()
        Forest.places.forEach { it.forEach { if (it is PlaceWithTree) uniqueTrees.add(it.tree)} }
        return uniqueTrees.size
    }
}