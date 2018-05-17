package com.company.view

import com.company.experimental.tree.TreeData
import com.company.forest.InProgress
import com.company.view.signals.TreeBox
import javafx.beans.property.SimpleStringProperty
import javafx.scene.text.FontWeight
import tornadofx.*

class TreeView: View() {
    var name =  SimpleStringProperty()
    var health = SimpleStringProperty()
    var age = SimpleStringProperty()
    var hunger = SimpleStringProperty()

    @InProgress override val root = vbox {
        subscribe<TreeBox> { updateProperties(it.tree) }

        setMinSize(100.0, 150.0)

        text {
            bind(name)
            style{fontWeight = FontWeight.BOLD}

        }
        text().bind(health)
        text().bind(age)
        text().bind(hunger)
        //TODO Parts of Tree
    }

    private fun updateProperties(tree: TreeData) {
//        name.value = tree.name
//        health.value = "Health: " + tree.health.toString() + "/" + tree.maxHealth.toString()
//        age.value = "Age: " + tree.age.toString() + "/" + tree.maxAge.toString()
//        hunger.value = "Hunger: " + tree.hunger.toString()
    }
}