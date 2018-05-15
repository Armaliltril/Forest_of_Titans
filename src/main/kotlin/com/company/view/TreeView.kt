package com.company.view

import com.company.forest.InProgress
import com.company.forest.organisms.trees.TreeFactory
import com.company.view.signals.TreeBox
import tornadofx.*

class TreeView: View() {
    var tree = TreeFactory.getRandomTree()

    @InProgress override val root = vbox {
        subscribe<TreeBox> { treeBox -> tree = treeBox.tree }

        label(tree.name)
        label("Health: " + tree.health + "/" + tree.maxHealth)
        label("Age: " + tree.age + "/" + tree.maxAge)
        label("Hunger: " + tree.hunger + "/100")

        //TODO Parts of Tree
    }
}