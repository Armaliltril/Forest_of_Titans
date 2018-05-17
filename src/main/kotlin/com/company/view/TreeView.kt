package com.company.view

import com.company.experimental.tree.TreeData
import com.company.forest.InProgress
import com.company.view.signals.TreeBox
import javafx.beans.property.SimpleStringProperty
import javafx.scene.text.FontWeight
import tornadofx.*

class TreeView: View() {
    var name =  SimpleStringProperty()
    var food = SimpleStringProperty()

    @InProgress override val root = vbox {
        subscribe<TreeBox> { updateProperties(it.tree) }

        setMinSize(100.0, 150.0)

        text {
            bind(name)
            style{fontWeight = FontWeight.BOLD}
        }
        text().bind(food)
        //TODO Parts of Tree
    }

    private fun updateProperties(tree: TreeData) {
          name.value = tree.name
          food.value = "Food: " + tree.food.toString() + "/" + tree.maxFood.toString()
    }
}