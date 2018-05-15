package com.company.forest.organisms.animals

import com.company.forest.InProgress
import java.util.*

object AnimalFactory {
    @InProgress fun getRandomAnimal(): Animal {
        return when (Random().nextInt(2)) {
            0 ->  ExampleHerbivorous()
            1 ->  ExampleCarnivorous()
            else -> throw RuntimeException()
        }
    }
}