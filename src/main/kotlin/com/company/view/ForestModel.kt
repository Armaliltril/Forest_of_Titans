package com.company.view

import com.company.forest.Forest
import tornadofx.*

class ForestModel(): ViewModel() {
    val placesProprety = Forest.places.toProperty()
    var places by placesProprety
}