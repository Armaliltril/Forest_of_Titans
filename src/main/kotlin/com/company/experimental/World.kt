package com.company.experimental

import com.company.forest.Forest
import java.util.*

class World {
    private val rnd = Random()
    private val animalBehaviorTypes: ArrayList<Pair<Animal, Int>> = ArrayList()
    private val treeBehaviorTypes: ArrayList<Pair<Tree, Int>> = ArrayList()

    private var worldTime = 0

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

    fun run() {
        create()
        while(currentAnimalNumber < limitAnimalNumber){
            tick()
        }
    }

    private fun create() {
        for (pair in animalBehaviorTypes){
            //
            pair.first.associateWith(animalHerald)
            // Start number of animals for this behavior
            for (i in 0 until (pair.second / commonAnimalRatio * startAnimalNumber).toInt()){
                animals.add(Pair(pair.first, pair.first.createData()))
                currentAnimalNumber += 1
            }
        }
        for (pair in treeBehaviorTypes){
            //
            pair.first.associateWith(treeHerald)
            // Start number of animals for this behavior
            for (i in 0 until (pair.second / commonTreeRatio * startAnimalNumber).toInt()){
                trees.add(Pair(pair.first, pair.first.createData()))
            }
        }
    }

    private fun tick(){
        worldTime += 1
        treeTurn()
        animalTurn()
    }

    private fun treeTurn(){
        val firstOrder = (0 until trees.size).sortedBy {rnd.nextDouble()}
        for (i in firstOrder){
            treeHerald.associateWith(trees[i].first, trees[i].second)
            treeHerald.tick()
        }
    }

    private fun animalTurn(){
        val firstOrder = (0 until currentAnimalNumber).sortedBy {rnd.nextDouble()}
        val secondOrder = firstWave(animals, firstOrder)
        secondWave(animals, secondOrder)
        animals = reborn(animals)
    }

    private fun firstWave(animals: List<Pair<Animal, AnimalData>>, firstOrder: List<Int>) : List<Int>{
        val secondOrder = mutableListOf<Int>()
        animalHerald.turnNumber = 1
        for (i in firstOrder){
            animalHerald.associateWith(animals[i].first, animals[i].second)
            animalHerald.tick()
            if (animalHerald.needsAdditionalTurn){
                secondOrder.add(i)
            }
        }
        return secondOrder
    }
    private fun secondWave(animals: List<Pair<Animal, AnimalData>>, secondOrder:  List<Int>) {
        animalHerald.turnNumber = 2
        for (i in secondOrder){
            animalHerald.associateWith(animals[i].first, animals[i].second)
            animalHerald.tick()
        }
    }
    private fun reborn(animals: List<Pair<Animal, AnimalData>>): MutableList<Pair<Animal, AnimalData>> {
        return animals.filter { it.second.isAlive }.toMutableList()
    }

    class Builder {

        private val world = World()

        constructor() {}

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

        fun setLimitAnimalNumber(lifeLimit: Int) : Builder {
            world.limitAnimalNumber = lifeLimit
            return this
        }

        fun setStartAnimalNumber(startAnimalNumber: Int): Builder {
            world.startAnimalNumber = startAnimalNumber
            return this
        }

        fun setTreeNumber(treeNumber : Int): Builder {
            world.startTreeNumber = treeNumber
            return this
        }

        fun build(): World {
            return world
        }
    }
}