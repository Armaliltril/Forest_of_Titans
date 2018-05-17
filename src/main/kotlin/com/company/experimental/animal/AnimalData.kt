package com.company.experimental.animal

import com.company.experimental.Directions
import com.company.experimental.Rotations
import com.company.forest.Forest
import com.company.forest.Place
import com.company.forest.PlaceWithTree
import com.company.forest.PlaceWithoutTree

class AnimalData {
    lateinit var behavior: Animal
        private set

    var name: String = ""

    var maxHealth: Int = 0
        private set
    var maxAge: Int = 0
        private set
    var maxHunger: Int = 0
        private set

    var xPosition: Int = 0
        private set
    var yPosition: Int = 0
        private set

    var health: Int = 0
        private set
    var age: Int = 0
        private set
    var hunger: Int = 0
        private set

    var isAlive = true
        private set
//
//    var curEnergy = 10
//        private set
//    var maxEnergy = 10
//        private set

    var direction = Directions.UP
        private set

    class Builder {
        private val animalData: AnimalData = AnimalData()

        fun setName(param: String): Builder {
            animalData.name = param
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

        fun setYPosition(param: Int): Builder {
            animalData.yPosition = param
            return this
        }

        fun setXPosition(param: Int): Builder {
            animalData.xPosition = param
            return this
        }

        fun setBehavior(animal: Animal): Builder {
            animalData.behavior = animal
            return this
        }

        fun build(): AnimalData {
            animalData.health = animalData.maxHealth
            return animalData
        }
    }


    class AnimalHerald : AnimalBehavior {

        var turnNumber: Int = 0

        lateinit var behavior: Animal
        lateinit var data: AnimalData

        var needsAdditionalTurn: Boolean = false

        fun associateWith(behavior: Animal, data: AnimalData) {
            this.behavior = behavior
            this.data = data
            this.needsAdditionalTurn = false

        }

        fun tick() {
            if (data.isAlive) {
                data.age += 1
                behavior.tick()
            }
        }

        fun getInfo(): AnimalData {
            return data
        }

        override fun goAhead() : Boolean{
            val direction = data.direction.value

            val curY = data.yPosition + direction.first
            val curX = data.xPosition + direction.second

            if (checkBounds(curX, curY) && checkPlace(curX, curY)) {
                val place = (Forest.places[data.yPosition][data.xPosition] as PlaceWithoutTree)
                place.animal = null
//                place.updateColor()

                data.xPosition = curX
                data.yPosition = curY
                val newPlace = (Forest.places[data.yPosition][data.xPosition] as PlaceWithoutTree)
                newPlace.animal = data
//                newPlace.updateColor()

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


        override fun eat(place: Place) : Boolean{
            return true
            TODO("implements method with coordinates")
        }

        override fun fight(place: Place): Boolean {
            return true
            TODO("implements method with coordinates")
        }

        override fun regenerate(): Boolean {
            return true
        }

        override fun reproduce(place: Place): Boolean {
            return true
            TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
        }


        private fun checkBounds(x: Int, y: Int, borderX: Int, borderY: Int): Boolean {
            return -1 < y && y < borderY && -1 < x && x < borderX
        }

        private fun checkBounds(x: Int, y: Int): Boolean {
            return checkBounds(x, y, Forest.size, Forest.size)
        }

        private fun checkPlace(x: Int, y: Int): Boolean {
            return Forest.places[y][x] !is PlaceWithTree && (Forest.places[y][x] as PlaceWithoutTree).animal == null
        }

        override fun turnAround(rotation: Rotations): Boolean {
            if (rotation == Rotations.RIGHT) {
                data.direction = nextDirection(data.direction)
            } else {
                data.direction = previousDirection(data.direction)
            }
            return true
        }

        fun nextDirection(direction: Directions): Directions {
            val index = Directions.values().indexOf(direction)
            return Directions.values()[(index + 1) % 4]
        }

        fun previousDirection(direction: Directions): Directions {
            val index = Directions.values().indexOf(direction)
            return Directions.values()[(index - 1) % 4]
        }

        override fun askExtraTurn(): Boolean {
            TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
        }
    }
}
