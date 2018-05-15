package com.company.view

import com.company.forest.PlaceWithTree
import com.company.forest.PlaceWithoutTree
import com.company.view.signals.AnimalRequest
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

                        if (places[i][j] is PlaceWithoutTree) {
                            this.add(circle {
                                radius = 2.5
                                val temp = places[i][j] as PlaceWithoutTree
                                fill = temp.color
                                onDoubleClick {
                                    fire(AnimalRequest)
                                }
                            })
                            fill = Color.LIGHTGRAY
                        }
                        else {
                            val temp = places[i][j] as PlaceWithTree
                            fill = temp.color
                        }

                    })
            }
        }
    }
}
