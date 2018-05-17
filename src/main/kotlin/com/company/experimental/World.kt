package com.company.experimental

import java.util.*

class World {
    private val rnd = Random()
    private val behaviorTypes: ArrayList<Pair<Animal, Int>> = ArrayList()

    private var worldTime = 0
    private var commonRatio = 0.0

    private var startAnimalNumber = 30
    private var currentAnimalNumber = 0
    private var limitAnimalNumber = 100

    private var animals: MutableList<Pair<Animal, AnimalData>> = ArrayList()
    private val herald : AnimalData.Herald = AnimalData.Herald()

    fun run() {
        create()
        while(currentAnimalNumber < limitAnimalNumber){
            tick()
        }
    }

    private fun create() {
        for (pair in behaviorTypes){
            //
            pair.first.associateWith(herald)
            // Start number of animals for this behavior
            for (i in 0 until (pair.second / commonRatio * startAnimalNumber).toInt()){
                animals.add(Pair(pair.first, pair.first.createData()))
                currentAnimalNumber += 1
            }
        }
    }

    private fun tick(){
        worldTime += 1
        treeTurn()
        animalTurn()
    }

    private fun treeTurn(){
        //TODO choose all woods step by step and update theirs state
    }

    private fun animalTurn(){
        val firstOrder = (0..currentAnimalNumber).sortedBy {rnd.nextDouble()}
        val secondOrder = firstWave(animals, firstOrder)
        secondWave(animals, secondOrder)
        animals = reborn(animals)
    }

    private fun firstWave(animals: List<Pair<Animal, AnimalData>>, firstOrder: List<Int>) : List<Int>{
        val secondOrder = mutableListOf<Int>()
        herald.turnNumber = 1
        for (i in firstOrder){
            herald.associateWith(animals[i].first, animals[i].second)
            herald.tick()
            if (herald.needsAdditionalTurn){
                secondOrder.add(i)
            }
        }
        return secondOrder
    }
    private fun secondWave(animals: List<Pair<Animal, AnimalData>>, secondOrder:  List<Int>) {
        herald.turnNumber = 2
        for (i in secondOrder){
            herald.associateWith(animals[i].first, animals[i].second)
            herald.tick()
        }
    }
    private fun reborn(animals: List<Pair<Animal, AnimalData>>): MutableList<Pair<Animal, AnimalData>> {
        return animals.filter { it.second.isAlive }.toMutableList()
    }

    class Builder {

        private val world = World()

        constructor() {}

        fun addBehavior(behavior: Animal, ratio: Int = 1): Builder {
            world.behaviorTypes.add(Pair(behavior, ratio))
            world.commonRatio += ratio
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

        fun build(): World {
            return world
        }
    }
}