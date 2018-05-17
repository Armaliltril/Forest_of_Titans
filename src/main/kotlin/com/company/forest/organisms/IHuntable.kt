package com.company.forest.organisms

import com.company.experimental.animal.AnimalData
import com.company.forest.InProgress

interface IHuntable {
    @InProgress fun hunt(animal: AnimalData) {

    }
}