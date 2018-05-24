package com.company.experimental.animal

import com.company.experimental.Directions
import com.company.experimental.Eatable
import com.company.experimental.Rotations
import com.company.forest.*

class AnimalData: Eatable {
    lateinit var behavior: Animal
        private set

    var target: Pair<Place, Char>? = null

    var name: String = ""
        private set

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
    var foodHealing: Int = 0
        private set

    var curEnergy = 10
        private set
    var maxEnergy = 10
        private set

    var isAlive = true
        private set

    override var eatableBy: ArrayList<AnimalType> = arrayListOf()
        private set


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
        var actionScore: Int = 0

        lateinit var behavior: Animal
        lateinit var data: AnimalData

        var needsAdditionalTurn: Boolean = false

        fun associateWith(behavior: Animal, data: AnimalData) {
            this.behavior = behavior
            this.data = data
            this.needsAdditionalTurn = false
            this.actionScore = 3

        }

        fun tick() {
            if (data.isAlive) {
                data.age += 1
                behavior.tick()
                needsAdditionalTurn = askExtraTurn()
            }
        }

        fun getInfo(): AnimalData {
            return data
        }

        override fun seeEnemies(): List<Place> {

            val results = mutableListOf<Place>()
            when (data.direction) {
                Directions.UP -> {
                    for (i in data.xPosition - 5 until data.xPosition + 5) {
                        for (j in data.yPosition until data.yPosition + 5) {
                            if (checkBounds(j, i)) {
                                val place = Forest.places[i][j]

                                if (place is PlaceWithoutTree && place.animal != null
                                        && behavior.javaClass != place.animal!!.behavior.javaClass) {
                                    results.add(place)
                                }
                            }
                        }
                    }
                }
                Directions.DOWN -> {
                    for (i in data.xPosition - 5 until data.xPosition + 5) {
                        for (j in data.yPosition + 5 downTo data.yPosition) {
                            if (checkBounds(j, i)) {
                                val place = Forest.places[i][j]
                                if (place is PlaceWithoutTree && place.animal != null &&
                                        behavior.javaClass != place.animal!!.behavior.javaClass) {
                                    results.add(place)
                                }
                            }
                        }
                    }
                }
                Directions.LEFT -> {
                    for (i in data.xPosition - 5 until  data.xPosition) {
                        for (j in data.yPosition - 5 until data.yPosition + 5) {
                            if (checkBounds(j, i)) {
                                val place = Forest.places[i][j]
                                if (place is PlaceWithoutTree && place.animal != null &&
                                        behavior.javaClass != place.animal!!.behavior.javaClass) {
                                    results.add(place)
                                }
                            }
                        }
                    }
                }
                Directions.RIGHT -> {
                    for (i in data.xPosition until data.xPosition + 5) {
                        for (j in data.yPosition - 5 until data.yPosition + 5) {
                            if (checkBounds(j, i)) {
                                val place = Forest.places[i][j]
                                if (place is PlaceWithoutTree && place.animal != null &&
                                        behavior.javaClass != place.animal!!.behavior.javaClass) {
                                    results.add(place)
                                }
                            }
                        }
                    }
                }
            }
            return results
        }

        override fun seeFood(): List<Place> {
            TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
        }

        override fun seeFriends(): List<Place> {
            TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
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


        @InProgress //Works for carnivorous only
        override fun eat(place: Place): Boolean {
            if (actionScore == 0) {
                return false
            }
            actionScore -= 2

            if (place is PlaceWithoutTree && place.animal != null) {
                if (place.animal!!.isAlive) {
                    return false
                }
                data.hunger -= place.animal!!.health / 10
                return true
            }
            return false
        }


        @InProgress //Not Fighting
        override fun fight(place: Place): Boolean {
            if (actionScore == 0) {
                return false
            }
            actionScore -= 2
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

        @InProgress //Not reproducing
        override fun reproduce(place: Place): Boolean {
            if (actionScore == 0) {
                return false
            }
            actionScore -= 2
            return true
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
            val newIndex = (index - 1) % 4
            return Directions.values()[if (newIndex != -1) newIndex else 3]
        }

        @InProgress
        override fun askExtraTurn(): Boolean {
            if (data.curEnergy < 5)
                return false
            data.curEnergy -= 5
            return true
        }
    }
}
