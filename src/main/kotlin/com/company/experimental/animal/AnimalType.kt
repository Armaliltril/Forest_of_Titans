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
    };

    protected fun createName(animal: Animal) =
            animal.getType().toString() + ":" + Random().nextInt()

    abstract fun createData(animal: Animal, xCoord : Int = 0, yCoord: Int = 0): AnimalData
}
