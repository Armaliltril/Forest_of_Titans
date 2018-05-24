package com.company.experimental.animal

import java.util.*

enum class AnimalType {

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
    },

    BADGER {
        override fun createData(animal: Animal, xCoord: Int, yCoord: Int): AnimalData =
                AnimalData.Builder()
                        .setBehavior(animal)
                        .setName(createName(animal))
                        .setMaxAge(10 * 1000)
                        .setMaxHealth(10 * 10)
                        .setFoodHealing(4 * 5)
                        .setMaxHunger(5 * 200)
                        .setXPosition(xCoord)
                        .setYPosition(yCoord)
                        .build()
    },

    SQUIRREL {
        override fun createData(animal: Animal, xCoord: Int, yCoord: Int): AnimalData =
                AnimalData.Builder()
                        .setBehavior(animal)
                        .setName(createName(animal))
                        .setMaxAge(2 * 1000)
                        .setMaxHealth(1 * 10)
                        .setFoodHealing(1 * 5)
                        .setMaxHunger(1 * 200)
                        .setXPosition(xCoord)
                        .setYPosition(yCoord)
                        .build()
    },

    FLYING_SQUIRREL {
        override fun createData(animal: Animal, xCoord: Int, yCoord: Int): AnimalData =
                AnimalData.Builder()
                        .setBehavior(animal)
                        .setName(createName(animal))
                        .setMaxAge(3 * 1000)
                        .setMaxHealth(2 * 10)
                        .setFoodHealing(1 * 5)
                        .setMaxHunger(2 * 200)
                        .setXPosition(xCoord)
                        .setYPosition(yCoord)
                        .build()
    },

    CHIPMUNK {
        override fun createData(animal: Animal, xCoord: Int, yCoord: Int): AnimalData =
                AnimalData.Builder()
                        .setBehavior(animal)
                        .setName(createName(animal))
                        .setMaxAge(3 * 1000)
                        .setMaxHealth(2 * 10)
                        .setFoodHealing(1 * 5)
                        .setMaxHunger(2 * 200)
                        .setXPosition(xCoord)
                        .setYPosition(yCoord)
                        .build()
    },

    WOODPECKER {
        override fun createData(animal: Animal, xCoord: Int, yCoord: Int): AnimalData =
                AnimalData.Builder()
                        .setBehavior(animal)
                        .setName(createName(animal))
                        .setMaxAge(5 * 1000)
                        .setMaxHealth(2 * 10)
                        .setFoodHealing(1 * 5)
                        .setMaxHunger(3 * 200)
                        .setXPosition(xCoord)
                        .setYPosition(yCoord)
                        .build()
    },

    WOLF {
        override fun createData(animal: Animal, xCoord: Int, yCoord: Int): AnimalData =
                AnimalData.Builder()
                        .setBehavior(animal)
                        .setName(createName(animal))
                        .setMaxAge(10 * 1000)
                        .setMaxHealth(15 * 10)
                        .setFoodHealing(20 * 5)
                        .setMaxHunger(10 * 200)
                        .setXPosition(xCoord)
                        .setYPosition(yCoord)
                        .build()
    },

    VULTURE {
        override fun createData(animal: Animal, xCoord: Int, yCoord: Int): AnimalData =
                AnimalData.Builder()
                        .setBehavior(animal)
                        .setName(createName(animal))
                        .setMaxAge(7 * 1000)
                        .setMaxHealth(8 * 10)
                        .setFoodHealing(8 * 5)
                        .setMaxHunger(8 * 200)
                        .setXPosition(xCoord)
                        .setYPosition(yCoord)
                        .build()
    };

    protected fun createName(animal: Animal) =
            animal.getType().toString() + ":" + Random().nextInt()

    abstract fun createData(animal: Animal, xCoord : Int = 0, yCoord: Int = 0): AnimalData
}
