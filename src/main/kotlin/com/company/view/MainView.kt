package com.company.view

import com.company.app.Styles
import com.company.forest.InProgress
import tornadofx.*

@InProgress class MainView: View() {
    private val forestUpdater = find(ForestUpdater::class)
    private val forestGrid = find(ForestGrid::class)
    private val topMenu = find(TopMenu::class)
    private val animalView = find(AnimalView::class)
    private val treeView = find(TreeView::class)

    override val root = vbox {
        title = "Forest of Titans"
        add(topMenu)
        add(forestUpdater)
        hbox {
            add(forestGrid)
            add(treeView)
            add(animalView)
        }
        button("REFRESH") {
            action {
                find(Fuu::class).openModal()
            }
        }
    }

    class Fuu: Fragment() {
        override val root = hbox {
            label("FUUUUUU")
        }
    }
}



