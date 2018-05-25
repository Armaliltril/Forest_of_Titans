package com.company.forest.organisms.animal

import java.util.*

enum class AnimalType {

    WALKING_MEAT {
        override fun createData(animal: Animal, xCoord: Int, yCoord: Int): AnimalData =
                AnimalData.Builder()
                        .setBehavior(animal)
                        .setName(createName(animal))
                        .setStrength(1)
                        .setMaxAge(1000)
                        .setMaxHealth(10)
                        .setFoodHealing(10)
                        .setMaxHunger(1000)
                        .setMaxEnergy(10)
                        .setXPosition(xCoord)
                        .setYPosition(yCoord)
                        .setHunters(arrayListOf(WALKING_MEAT))
                        .build()
    },

    BADGER {
        override fun createData(animal: Animal, xCoord: Int, yCoord: Int): AnimalData =
                AnimalData.Builder()
                        .setBehavior(animal)
                        .setName(createName(animal))
                        .setStrength(4 * 10)
                        .setMaxAge(10 * 1000)
                        .setMaxHealth(10 * 10)
                        .setFoodHealing(4 * 5)
                        .setMaxHunger(5 * 200)
                        .setMaxEnergy(1 * 5)
                        .setXPosition(xCoord)
                        .setYPosition(yCoord)
                        .setHunters(arrayListOf(WOLF))
                        .build()
    },

    SQUIRREL {
        override fun createData(animal: Animal, xCoord: Int, yCoord: Int): AnimalData =
                AnimalData.Builder()
                        .setBehavior(animal)
                        .setName(createName(animal))
                        .setStrength(1 * 10)
                        .setMaxAge(2 * 1000)
                        .setMaxHealth(1 * 10)
                        .setFoodHealing(1 * 5)
                        .setMaxHunger(1 * 200)
                        .setMaxEnergy(2 * 5)
                        .setXPosition(xCoord)
                        .setYPosition(yCoord)
                        .setHunters(arrayListOf(VULTURE, WOLF))
                        .build()
    },

    FLYING_SQUIRREL {
        override fun createData(animal: Animal, xCoord: Int, yCoord: Int): AnimalData =
                AnimalData.Builder()
                        .setBehavior(animal)
                        .setName(createName(animal))
                        .setStrength(1 * 10)
                        .setMaxAge(3 * 1000)
                        .setMaxHealth(2 * 10)
                        .setFoodHealing(1 * 5)
                        .setMaxHunger(2 * 200)
                        .setMaxEnergy(2 * 5)
                        .setXPosition(xCoord)
                        .setYPosition(yCoord)
                        .setHunters(arrayListOf(VULTURE))
                        .build()
    },

    CHIPMUNK {
        override fun createData(animal: Animal, xCoord: Int, yCoord: Int): AnimalData =
                AnimalData.Builder()
                        .setBehavior(animal)
                        .setName(createName(animal))
                        .setStrength(2 * 10)
                        .setMaxAge(3 * 1000)
                        .setMaxHealth(2 * 10)
                        .setFoodHealing(1 * 5)
                        .setMaxHunger(2 * 200)
                        .setMaxEnergy(3 * 5)
                        .setXPosition(xCoord)
                        .setYPosition(yCoord)
                        .setHunters(arrayListOf(WOLF))
                        .build()
    },

    WOODPECKER {
        override fun createData(animal: Animal, xCoord: Int, yCoord: Int): AnimalData =
                AnimalData.Builder()
                        .setBehavior(animal)
                        .setName(createName(animal))
                        .setStrength(2 * 10)
                        .setMaxAge(5 * 1000)
                        .setMaxHealth(2 * 10)
                        .setFoodHealing(1 * 5)
                        .setMaxHunger(3 * 200)
                        .setMaxEnergy(2 * 5)
                        .setXPosition(xCoord)
                        .setYPosition(yCoord)
                        .setHunters(arrayListOf(VULTURE))
                        .build()
    },

    WOLF {
        override fun createData(animal: Animal, xCoord: Int, yCoord: Int): AnimalData =
                AnimalData.Builder()
                        .setBehavior(animal)
                        .setName(createName(animal))
                        .setStrength(10 * 10)
                        .setMaxAge(10 * 1000)
                        .setMaxHealth(15 * 10)
                        .setFoodHealing(20 * 5)
                        .setMaxHunger(10 * 200)
                        .setMaxEnergy(4 * 5)
                        .setXPosition(xCoord)
                        .setYPosition(yCoord)
                        .setHunters(arrayListOf())
                        .build()
    },

    VULTURE {
        override fun createData(animal: Animal, xCoord: Int, yCoord: Int): AnimalData =
                AnimalData.Builder()
                        .setBehavior(animal)
                        .setName(createName(animal))
                        .setStrength(6 * 10)
                        .setMaxAge(7 * 1000)
                        .setMaxHealth(8 * 10)
                        .setFoodHealing(8 * 5)
                        .setMaxHunger(8 * 200)
                        .setMaxEnergy(3 * 5)
                        .setXPosition(xCoord)
                        .setYPosition(yCoord)
                        .setHunters(arrayListOf())
                        .build()
    };

    protected fun createName(animal: Animal) =
            animal.getType().toString() + ":" + Random().nextInt()

    abstract fun createData(animal: Animal, xCoord : Int = 0, yCoord: Int = 0): AnimalData
}
