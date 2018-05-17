package com.company.forest.util

import com.company.experimental.animal.Animal
import com.company.experimental.animal.AnimalData
import com.company.experimental.tree.Tree
import com.company.experimental.tree.TreeData
import com.company.forest.Forest
import com.company.forest.InProgress
import com.company.forest.PlaceWithTree
import com.company.forest.PlaceWithoutTree

@InProgress
object Observer {
    inline fun <reified T: AnimalData> countAnimals(): Int {
        var counter = 0
        Forest.places.forEach { it.forEach { if (it is PlaceWithoutTree && it.animal is T) counter++} }
        return counter;
    }
    inline fun <reified T: TreeData> countTrees(): Int {
        val uniqueTrees = mutableSetOf<TreeData>()
        Forest.places.forEach { it.forEach { if (it is PlaceWithTree && it.tree is T) uniqueTrees.add(it.tree)} }
        return uniqueTrees.size;
    }
}