package com.company.experimental.animal

import com.company.forest.Place

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

        fun build() : AnimalData {
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

        fun tick(){
            if (data.isAlive){
                data.age += 1
                behavior.tick()
            }
        }

        fun getInfo() : AnimalData {
            return data
        }

        override fun rotateRightHand(right: Boolean) {
            TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
        }

        override fun goAhead() {
            TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
        }


        override fun eat(place: Place) {
            TODO("implements method with coordinates")
        }

        override fun fight(place: Place) {
            TODO("implements method with coordinates")
        }

        override fun regenerate() {

        }

        override fun reproduce(place: Place) {
            TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
        }

        override fun askExtraTurn() {
            return
//            if (turnNumber == 1 && data.isAlive){
//                needsAdditionalTurn = true
//            }
        }
    }
}