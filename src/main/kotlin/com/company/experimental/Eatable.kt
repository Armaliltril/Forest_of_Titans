package com.company.experimental

import com.company.experimental.animal.AnimalType
import com.company.forest.InProgress

interface Eatable {
    val eatableBy: ArrayList<AnimalType>
}
