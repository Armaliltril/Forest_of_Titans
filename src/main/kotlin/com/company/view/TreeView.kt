package com.company.view

import com.company.experimental.tree.TreeData
import com.company.forest.InProgress
import com.company.view.signals.TreeBox
import javafx.beans.property.SimpleStringProperty
import javafx.scene.text.FontWeight
import tornadofx.*

class TreeView: View() {
    private var name =  SimpleStringProperty()
    private var foodOnCrown = SimpleStringProperty()
    private var foodOnTrunk = SimpleStringProperty()
    private var foodOnRoots = SimpleStringProperty()

    @InProgress override val root = vbox {
        subscribe<TreeBox> { updateProperties(it.tree) }

        setMinSize(150.0, 150.0)

        text {
            bind(name)
            style{fontWeight = FontWeight.BOLD}
        }
        text().bind(foodOnCrown)
        text().bind(foodOnTrunk)
        text().bind(foodOnRoots)
    }

    private fun updateProperties(tree: TreeData) {
          name.value = tree.name
          foodOnCrown.value = "Crown food: " + tree.treeFood.onCrown.toString() + "/" + tree.treeFood.maxOnCrown.toString()
          foodOnTrunk.value = "Crown food: " + tree.treeFood.onTrunk.toString() + "/" + tree.treeFood.maxOnTrunk.toString()
          foodOnRoots.value = "Crown food: " + tree.treeFood.onRoots.toString() + "/" + tree.treeFood.maxOnRoots.toString()
    }
}