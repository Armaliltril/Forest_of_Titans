package com.company.view

import com.company.forest.Forest
import com.company.view.signals.UpdateSignal
import tornadofx.*

class ForestModel(): ViewModel() {
    val placesProprety = Forest.places.toProperty()
    var places by placesProprety

    fun update() {
        Forest.tick()
    }
}