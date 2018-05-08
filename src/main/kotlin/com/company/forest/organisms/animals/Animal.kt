package com.company.forest.organisms.animals

import com.company.forest.InProgress
import com.company.forest.Place
import com.company.forest.organisms.IMovable
import com.company.forest.organisms.Organism

abstract class Animal: Organism(), IMovable {
    abstract val power: Int

    var stamina: Int
    var mindMap: ArrayList<ArrayList<Place>>

    @InProgress open fun updateMindMap() {

    }
    @InProgress open fun rest() {

    }
    @InProgress fun fight(animal: Animal) {

    }

    init {
        stamina = 0
        mindMap = arrayListOf()
    } //TODO() proper initialization
}