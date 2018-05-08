package com.company.view

import com.company.app.Styles
import com.company.forest.InProgress
import tornadofx.*

@InProgress class MainView: View() {
    private val forestGrid = find(ForestGrid::class)
    override val root = hbox {
        title = "Forest of Titans"
        add(forestGrid)
    }

    class ForestGrid: View() {
        override val root = gridpane {
            row {
                label("Once it will be done")
            }
            row {
                label("Yep, yep!")
            }
        }
    }
}



