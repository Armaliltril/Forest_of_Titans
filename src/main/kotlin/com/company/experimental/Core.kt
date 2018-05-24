package com.company.experimental

import com.company.experimental.animal.Animal
import com.company.experimental.animal.AnimalData
import com.company.experimental.tree.Tree
import com.company.experimental.tree.TreeData
import com.company.forest.Forest
import com.company.forest.Place
import com.company.forest.PlaceWithTree
import com.company.forest.PlaceWithoutTree
import com.company.forest.util.makeArrayList
import java.util.*
import kotlin.collections.ArrayList

class Core private constructor() {
    private val rnd = Random()
    private val animalBehaviorTypes: ArrayList<Pair<Animal, Int>> = ArrayList()
    private val treeBehaviorTypes: ArrayList<Pair<Tree, Int>> = ArrayList()

    var worldTime = 0

    private var commonTreeRatio = 0.0
    private var startTreeNumber = 30

    private var startAnimalNumber = 30
    private var commonAnimalRatio = 0.0
    private var currentAnimalNumber = 0
    private var limitAnimalNumber = 100

    private var animals: MutableList<Pair<Animal, AnimalData>> = ArrayList()
    private var trees: MutableList<Pair<Tree, TreeData>> = ArrayList()

    private val animalHerald = AnimalData.AnimalHerald()
    private val treeHerald = TreeData.TreeHerald()

    lateinit var places: ArrayList<ArrayList<Place>>
        private set

    fun createOrganisms() {
        val treeCenterCoordinates = com.company.forest.util.Random.defineTreePlaces(Forest.size)
        var counter = 0

        for (pair in treeBehaviorTypes) {
            pair.first.associateWith(treeHerald)
            // Start number of animals for this behavior
            for (c in 0 until (pair.second / commonTreeRatio * startTreeNumber).toInt()) {
                val it = treeCenterCoordinates[counter++]
                val treeData = pair.first.createData(it.first, it.second)
                for (i in it.second - 2..it.second + 2) {
                    for (j in it.first - 2..it.first + 2) {
                        places[i][j] = PlaceWithTree(treeData)
                    }
                }
                trees.add(Pair(pair.first, treeData))
            }
        }

        for (pair in animalBehaviorTypes) {
            pair.first.associateWith(animalHerald)
            // Start number of animals for this behavior
            for (c in 0 until (pair.second / commonAnimalRatio * startAnimalNumber).toInt()) {
                var i: Int
                var j: Int
                do {
                    i = rnd.nextInt(Forest.size)
                    j = rnd.nextInt(Forest.size)
                } while (places[i][j] is PlaceWithTree)

                val animalData = pair.first.createData(j, i)
                places[i][j] = PlaceWithoutTree(animalData)
                animals.add(Pair(pair.first, animalData))
                currentAnimalNumber += 1
            }
        }
    }

    fun tick() {
        worldTime += 1
        treeTurn()
        animalTurn()
        places.forEach { it.forEach { (it as? PlaceWithoutTree)?.updateColor() } }
    }

    private fun createPlaces() {
        places = arrayListOf()
        val tempPlace = Place()
        for (i in 0 until Forest.size)
            places.add(makeArrayList(Forest.size, tempPlace))
        for (i in 0 until Forest.size) {
            for (j in 0 until Forest.size) {
                places[i][j] = PlaceWithoutTree(null)
            }
        }
    }

    private fun treeTurn() {
        val firstOrder = (0 until trees.size).sortedBy { rnd.nextDouble() }
        for (i in firstOrder) {
            treeHerald.associateWith(trees[i].first, trees[i].second)
            treeHerald.tick()
        }
    }

    private fun animalTurn() {
        val firstOrder = (0 until currentAnimalNumber).sortedBy { rnd.nextDouble() }
        val secondOrder = firstWave(animals, firstOrder)
        secondWave(animals, secondOrder)
        animals = reborn(animals)
    }

    private fun firstWave(animals: List<Pair<Animal, AnimalData>>, firstOrder: List<Int>): List<Int> {
        val secondOrder = mutableListOf<Int>()
        animalHerald.turnNumber = 1
        for (i in firstOrder) {
            animalHerald.associateWith(animals[i].first, animals[i].second)
            animalHerald.tick()
            if (animalHerald.needsAdditionalTurn) {
                secondOrder.add(i)
            }
        }
        return secondOrder
    }

    private fun secondWave(animals: List<Pair<Animal, AnimalData>>, secondOrder: List<Int>) {
        animalHerald.turnNumber = 2
        for (i in secondOrder) {
            animalHerald.associateWith(animals[i].first, animals[i].second)
            animalHerald.tick()
        }
    }

    private fun reborn(animals: List<Pair<Animal, AnimalData>>): MutableList<Pair<Animal, AnimalData>> {
        return animals.filter { it.second.isAlive }.toMutableList()
    }

    class Builder {

        private val world = Core()

        fun addAnimalBehavior(behavior: Animal, ratio: Int = 1): Builder {
            world.animalBehaviorTypes.add(Pair(behavior, ratio))
            world.commonAnimalRatio += ratio
            return this
        }

        fun addTreeBehavior(behavior: Tree, ratio: Int = 1): Builder {
            world.treeBehaviorTypes.add(Pair(behavior, ratio))
            world.commonTreeRatio += ratio
            return this
        }

        fun setLimitAnimalNumber(lifeLimit: Int): Builder {
            world.limitAnimalNumber = lifeLimit
            return this
        }

        fun setStartAnimalNumber(startAnimalNumber: Int): Builder {
            world.startAnimalNumber = startAnimalNumber
            return this
        }

        fun setTreeNumber(treeNumber: Int): Builder {
            world.startTreeNumber = treeNumber
            return this
        }

        fun build(): Core {
            world.createPlaces()
            return world
        }
    }
}