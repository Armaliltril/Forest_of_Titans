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
}



