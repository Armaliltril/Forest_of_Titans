package com.company.forest.organisms

import com.company.forest.InProgress
import com.company.forest.organisms.animals.Animal

interface IHuntable {
    @InProgress fun hunt(animal: Animal) {

    }
}