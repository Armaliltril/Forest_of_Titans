package com.company.view

import com.company.experimental.animal.AnimalData
import com.company.experimental.animal.example.StupidAnimal
import com.company.experimental.tree.TreeData
import com.company.experimental.tree.example.StupidTree
import com.company.forest.util.Observer
import com.company.view.signals.AnimalNumberBox
import com.company.view.signals.TreeNumberBox
import tornadofx.*

class Statistics: View() {
    override val root = vbox {
        menubar {
            menu("Count animals") {
                item("Example Carnivorous").action { fire(AnimalNumberBox(Observer.countAnimals<AnimalData>())) }
                item("Example Herbivorous").action { fire(AnimalNumberBox(Observer.countAnimals<AnimalData>())) }
            }
            menu("Count trees") {
                item("Example Tree").action { fire(TreeNumberBox(Observer.countTrees<TreeData>())) }
            }
        }
        hbox {
            text("Output: ")
            text {
                subscribe<AnimalNumberBox> { text = it.number.toString() }
            }
        }
    }
}