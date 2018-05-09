package com.company.view

import com.company.forest.Place
import javafx.scene.Parent
import javafx.scene.paint.Color
import tornadofx.*



class ForestGrid(): View() {
    val forestModel = ForestModel()
    val places = forestModel.places

    override val root = gridpane {
        for (i in 0 until places.size) {
            row {
                for (j in 0 until places.size)
                    add(rectangle {
                        height = 10.0
                        width = 10.0
                        fill = places[i][j].animals.color
                    })
            }
        }
    }
}
