package com.company.forest.organisms

import com.company.forest.InProgress

interface IEatable {
    @InProgress fun eatableBy(): List<Organism> {
        return listOf()
    }
}

class Organism {

}
