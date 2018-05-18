package com.company.view

import com.company.forest.Forest
import com.company.view.signals.ColorsBox
import com.company.view.signals.UpdateSignal
import javafx.scene.paint.Color
import tornadofx.*

class ForestModel(): ViewModel() {
    val placesProprety = Forest.places.toProperty()
    var places by placesProprety

    fun update() {
        Forest.tick()
        fire(ColorsBox(collectColors()))
    }

    fun collectColors(): ArrayList<ArrayList<Color>> {
        val colors = arrayListOf<ArrayList<Color>>()
        for (i in 0 until places.size) {
            val row = arrayListOf<Color>()
            for (j in 0 until places.size) {
                row.add(places[i][j].color)
            }
            colors.add(row)
        }
        return colors
    }
}