package com.company.forest.organisms

import com.company.forest.organisms.animal.AnimalType

interface Eatable {
    val eatableBy: ArrayList<AnimalType>
}
