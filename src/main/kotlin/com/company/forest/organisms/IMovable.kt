package com.company.forest.organisms

import com.company.forest.InProgress
import com.company.forest.Place

interface IMovable {
    @InProgress fun move(place: Place) {

    }
}