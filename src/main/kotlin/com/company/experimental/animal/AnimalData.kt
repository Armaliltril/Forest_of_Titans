package com.company.experimental.animal

import com.company.experimental.Directions
import com.company.experimental.Eatable
import com.company.experimental.Rotations
import com.company.experimental.tree.TreeFood
import com.company.forest.*
import com.company.forest.util.Random
import java.lang.Integer.max
import kotlin.math.abs

class AnimalData : Eatable {
    lateinit var behavior: Animal
        private set

    var name: String = ""
        private set

    var maxHealth: Int = 0
        private set
    var maxAge: Int = 0
        private set
    var maxHunger: Int = 0
        private set
    var maxEnergy = 10
        private set

    var xPosition: Int = 0
        private set
    var yPosition: Int = 0
        private set

    var health: Int = 0

    var age: Int = 0
        private set
    var hunger: Int = 0
        private set
    var foodHealing: Int = 0
        private set
    var strength: Int = 0
        private set
    var energy = 10
        private set

    var isAlive = true
        private set

    override var eatableBy: ArrayList<AnimalType> = arrayListOf()
        private set

    var direction = Directions.UP
        private set

    var memories: MutableList<Memory> = mutableListOf()

    class Builder {
        private val animalData: AnimalData = AnimalData()

        fun setName(param: String): Builder {
            animalData.name = param
            return this
        }

        fun setStrength(param: Int): Builder {
            animalData.strength = param
            return this
        }

        fun setMaxHealth(param: Int): Builder {
            animalData.maxHealth = param
            return this
        }

        fun setMaxAge(param: Int): Builder {
            animalData.maxAge = param
            return this
        }

        fun setMaxHunger(param: Int): Builder {
            animalData.maxHunger = param
            return this
        }

        fun setMaxEnergy(param: Int): Builder {
            animalData.maxEnergy = param
            return this
        }

        fun setYPosition(param: Int): Builder {
            animalData.yPosition = param
            return this
        }

        fun setXPosition(param: Int): Builder {
            animalData.xPosition = param
            return this
        }

        fun setFoodHealing(param: Int): Builder {
            animalData.foodHealing = param
            return this
        }

        fun setBehavior(animal: Animal): Builder {
            animalData.behavior = animal
            return this
        }

        fun setHunters(hunterList: ArrayList<AnimalType>): Builder {
            animalData.eatableBy = hunterList
            return this
        }

        fun build(): AnimalData {
            animalData.health = animalData.maxHealth
            return animalData
        }
    }

    class AnimalHerald : AnimalBehavior {

        var turnNumber: Int = 0
        private var actionScore: Int = 0
        var needsAdditionalTurn: Boolean = false

        lateinit var behavior: Animal
        lateinit var data: AnimalData

        fun tick() {
            if (data.isAlive) {
                data.age += 1
                behavior.tick()
                needsAdditionalTurn = askExtraTurn()
            }
        }

        fun associateWith(behavior: Animal, data: AnimalData) {
            this.behavior = behavior
            this.data = data
            this.needsAdditionalTurn = false
            this.actionScore = 3

            updateMemory()
        }

        override fun seeFront() {

            when (data.direction) {
                Directions.UP -> {
                    for (i in data.xPosition - 5 until data.xPosition + 5) {
                        for (j in data.yPosition until data.yPosition + 5) {
                            if (checkBounds(j, i)) {
                                val place = Forest.places[i][j]
                                checkIfPlaceChanged(place)
                            }
                        }
                    }
                }
                Directions.DOWN -> {
                    for (i in data.xPosition - 5 until data.xPosition + 5) {
                        for (j in data.yPosition + 5 downTo data.yPosition) {
                            if (checkBounds(j, i)) {
                                val place = Forest.places[i][j]
                                checkIfPlaceChanged(place)
                            }
                        }
                    }
                }
                Directions.LEFT -> {
                    for (i in data.xPosition - 5 until data.xPosition) {
                        for (j in data.yPosition - 5 until data.yPosition + 5) {
                            if (checkBounds(j, i)) {
                                val place = Forest.places[i][j]
                                checkIfPlaceChanged(place)
                            }
                        }
                    }
                }
                Directions.RIGHT -> {
                    for (i in data.xPosition until data.xPosition + 5) {
                        for (j in data.yPosition - 5 until data.yPosition + 5) {
                            if (checkBounds(j, i)) {
                                val place = Forest.places[i][j]
                                checkIfPlaceChanged(place)
                            }
                        }
                    }
                }
            }
        }

        override fun goAhead(): Boolean {
            if (actionScore == 0) {
                return false
            }
            actionScore -= 2

            val direction = data.direction.value

            val curY = data.yPosition + direction.first
            val curX = data.xPosition + direction.second

            if (checkBounds(curX, curY) && noAnimalsInPlace(curX, curY)) {
                val place = (Forest.places[data.yPosition][data.xPosition] as PlaceWithoutTree)
                place.animal = null

                data.xPosition = curX
                data.yPosition = curY

                val newPlace = (Forest.places[data.yPosition][data.xPosition] as PlaceWithoutTree)
                newPlace.animal = data

                //updateMaps(data.x, data.y, curX, curY)
                return true
//                if (checkBounds(data.visionX + direction.first, data.visionY + direction.second, 30, 30)) {
//                    data.visionX += direction.first
//                    data.visionY += direction.second
//                } else {
//
//                }
            }
            return false
        }

        override fun eat(): Boolean {
            if (actionScore < 2)
                return false

            for (placeInMemory in data.memories) {
                if (abs(placeInMemory.place.x - data.xPosition) > 1 && abs(placeInMemory.place.y - data.yPosition) > 1)
                    continue
                fun tryEatAnimals(): Boolean {
                    val animal = placeInMemory.animalData
                    if (animal?.isAlive!! && animal.eatableBy.contains(data.behavior.getType())) {
                        actionScore -= 2
                        data.hunger = max(0, data.hunger - animal.health / 10)
                        return true
                    }
                    return false
                }
                fun tryEatOnTrees(): Boolean {
                    val treeFood = placeInMemory.treeData?.treeFood

                    if (treeFood!!.onCrown >= 5 && TreeFood.Level.CROWN.eatableBy.contains(data.behavior.getType())) {
                        actionScore -= 2
                        treeFood.onCrown -= 5
                        data.hunger = max(0, data.hunger - data.maxHunger / 10)
                        return true
                    }
                    if (treeFood.onTrunk >= 5 && TreeFood.Level.TRUNK.eatableBy.contains(data.behavior.getType())) {
                        actionScore -= 2
                        treeFood.onTrunk -= 5
                        data.hunger = max(0, data.hunger - data.maxHunger / 10)
                        return true
                    }
                    if (treeFood.onRoots >= 5 && TreeFood.Level.ROOTS.eatableBy.contains(data.behavior.getType())) {
                        actionScore -= 2
                        treeFood.onRoots -= 5
                        data.hunger = max(0, data.hunger - data.maxHunger / 10)
                        return true
                    }
                    return false
                }

                var isEaten = tryEatAnimals()
                if (!isEaten)
                    isEaten  = tryEatOnTrees()
                return isEaten
            }
            return false
        }

        override fun fight(otherAnimal: AnimalData): Boolean {
            if (actionScore < 2)
                return false

            actionScore -= 2
            Random.takeDamage(this.data, otherAnimal)
            return true
        }

        override fun regenerate(): Boolean {
            if (actionScore == 0) {
                return false
            }
            actionScore -= 2
            if (data.hunger < 0) {
                data.health += data.foodHealing
                return true
            }
            return false
        }

        @InProgress
        override fun reproduce(otherAnimal: AnimalData): Boolean {
            if (actionScore == 0) {
                return false
            }
            actionScore -= 2
            if (Random.tryReproduce(this.data, otherAnimal)) {
                fun spawnBaby(place: Place) {
                    TODO()
                }

                for (i in -1..1) {
                    for (j in -1..1) {
                        val currentCoordinates = Pair(data.xPosition + i, data.yPosition + j)
                        if (noAnimalsInPlace(currentCoordinates.first, currentCoordinates.second)) {
                            spawnBaby(Forest.places[currentCoordinates.first][currentCoordinates.second])
                        }
                    }
                }
            }
            return true
        }

        override fun turnAround(rotation: Rotations): Boolean {
            if (rotation == Rotations.RIGHT) {
                data.direction = nextDirection(data.direction)
            } else {
                data.direction = previousDirection(data.direction)
            }
            return true
        }

        override fun askExtraTurn(): Boolean {
            if (data.energy < 5)
                return false
            data.energy -= 5
            return true
        }

        private fun checkIfPlaceChanged(place: Place){
            if (place is PlaceWithoutTree && place.animal != null)
            {
                val result = data.memories.find{it.isSame(place.animal)}
                if (result != null){
                    result.updatePlace(place)
                }
                else{
                    data.memories.add(Memory(place, place.animal, null))
                }
            }
            else if (place is PlaceWithTree){
                val result = data.memories.find{it.isSame(place.tree )}
                if (result != null){
                    result.updatePlace(place)
                }
                else{
                    data.memories.add(Memory(place, null, place.tree))
                }
            }
        }

        private fun updateMemory(){
            data.memories.forEach { it.goTime() }
            data.memories = data.memories.filter { it.time > 0 }.toMutableList()
        }

        private fun checkBounds(x: Int, y: Int, borderX: Int, borderY: Int): Boolean {
            return -1 < y && y < borderY && -1 < x && x < borderX
        }

        private fun checkBounds(x: Int, y: Int): Boolean {
            return checkBounds(x, y, Forest.size, Forest.size)
        }

        private fun noAnimalsInPlace(x: Int, y: Int): Boolean {
            return Forest.places[y][x] !is PlaceWithTree && (Forest.places[y][x] as PlaceWithoutTree).animal == null
        }

        private fun nextDirection(direction: Directions): Directions {
            val index = Directions.values().indexOf(direction)
            return Directions.values()[(index + 1) % 4]
        }

        private fun previousDirection(direction: Directions): Directions {
            val index = Directions.values().indexOf(direction)
            val newIndex = (index - 1) % 4
            return Directions.values()[if (newIndex != -1) newIndex else 3]
        }
    }
}
