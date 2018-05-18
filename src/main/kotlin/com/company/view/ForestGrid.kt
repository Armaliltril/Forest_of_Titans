package com.company.view

import com.company.forest.PlaceWithTree
import com.company.forest.PlaceWithoutTree
import com.company.forest.util.makeArrayList
import com.company.view.signals.AnimalBox
import com.company.view.signals.ColorsBox
import com.company.view.signals.TreeBox
import javafx.scene.paint.Color
import tornadofx.*

class ForestGrid(): View() {
    val forestModel = ForestModel()
    val places = forestModel.places
    var colors: ArrayList<ArrayList<Color>>

    override val root = gridpane {
        for (i in 0 until places.size) {
            row {
                for (j in 0 until places.size) {
                    if (places[i][j] is PlaceWithTree) {
                        rectangle {
                            height = 10.0
                            width = 10.0

                            onDoubleClick {
                                val temp = places[i][j] as PlaceWithTree
                                fire(TreeBox(temp.tree))
                            }
                            subscribe<ColorsBox> { fill = it.colors[i][j] }
                        }
                    }
                    else if (places[i][j] is PlaceWithoutTree) {
                        stackpane {
                            rectangle {
                                height = 10.0
                                width = 10.0
                                fill = Color.WHITE
                            }
                            circle {
                                radius = 5.0

                                onDoubleClick {
                                    val temp = places[i][j] as PlaceWithoutTree
                                    if (temp.animal != null)
                                        fire(AnimalBox(temp.animal!!))
                                }
                                subscribe<ColorsBox> { fill = it.colors[i][j] }
                            }
                        }
                    }
                }
            }
        }
    }

    init {
        colors = arrayListOf()
        for (i in 0 until places.size)
            colors.add(makeArrayList(places.size, Color.WHITE))
    }
}
