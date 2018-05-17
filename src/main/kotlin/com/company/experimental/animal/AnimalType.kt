package com.company.experimental.animal

import java.util.*

enum class AnimalType {

    CARNIVOROUS() {
        override fun createData(animal: Animal, xCoord: Int, yCoord: Int): AnimalData =
                AnimalData.Builder()
                        .setName(createName((animal)))
                        .setMaxAge(100)
                        .setMaxHealth(100)
                        .setMaxHunger(30)
                        .setFoodHealing(10)
                        .setXPosition(xCoord)
                        .setYPosition(yCoord)
                        .build()
    },

    HERBIVOROUS {
        override fun createData(animal: Animal, xCoord: Int, yCoord: Int): AnimalData =
                AnimalData.Builder()
                        .setName(createName(animal))
                        .setMaxAge(20)
                        .setMaxHealth(200)
                        .setFoodHealing(10)
                        .setMaxHunger(10)
                        .setXPosition(xCoord)
                        .setYPosition(yCoord)
                        .build()
    },

    WALKING_MEAT {
        override fun createData(animal: Animal, xCoord: Int, yCoord: Int): AnimalData =
                AnimalData.Builder()
                        .setBehavior(animal)
                        .setName(createName(animal))
                        .setMaxAge(1000)
                        .setMaxHealth(10)
                        .setFoodHealing(10)
                        .setMaxHunger(1000)
                        .setXPosition(xCoord)
                        .setYPosition(yCoord)
                        .build()
    };

    private val rnd = Random()

    protected fun createName(animal: Animal) =
            animal.getType().toString() + ":" + rnd.nextInt()

    abstract fun createData(animal: Animal, xCoord : Int = 0, yCoord: Int = 0): AnimalData
}
