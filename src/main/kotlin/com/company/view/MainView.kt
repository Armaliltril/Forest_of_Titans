package com.company.view

import com.company.app.Styles
import com.company.forest.InProgress
import tornadofx.*

@InProgress class MainView: View() {
    private val forestGrid = find(ForestGrid::class)
    private val topMenu = find(TopMenu::class)
    private val animalView = find(AnimalView::class)
    private val treeView = find(TreeView::class)

    override val root = vbox {
        title = "Forest of Titans"
        add(topMenu)
        hbox {
            add(forestGrid)
            add(treeView)
            add(animalView)
        }
    }
}



