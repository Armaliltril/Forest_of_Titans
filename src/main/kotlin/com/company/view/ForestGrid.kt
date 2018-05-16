package com.company.view

import com.company.forest.PlaceWithTree
import com.company.forest.PlaceWithoutTree
import com.company.view.signals.AnimalBox
import com.company.view.signals.TreeBox
import javafx.scene.paint.Color
import tornadofx.*

//TODO FIX: Деревья съежают вправо из-за животных

class ForestGrid(): View() {
    val forestModel = ForestModel()
    val places = forestModel.places

    override val root = gridpane {
        for (i in 0 until places.size) {
            row {
                for (j in 0 until places.size) {
                    val stackPane = stackpane()
                    val rect = rectangle {
                        height = 10.0
                        width = 10.0
                    }

                    if (places[i][j] is PlaceWithoutTree) {
                        val temp = places[i][j] as PlaceWithoutTree
                        rect.fill = Color.WHITE
                        if (temp.animal != null) {
                            stackPane.add(rect)
                            stackPane.add(circle {
                                radius = 2.5
                                fill = temp.color

                                onDoubleClick { fire(AnimalBox(temp.animal!!)) }
                            })
                        }
                        else stackPane.add(rect)
                    }
                    else {
                        val temp = places[i][j] as PlaceWithTree
                        rect.apply {
                            fill = temp.color
                            onDoubleClick { fire(TreeBox(temp.tree)) }
                        }
                        stackPane.add(rect)
                    }
                    add(stackPane)
                }
            }
        }
    }
}
