package com.company.view

import com.company.forest.organisms.animals.ExampleCarnivorous
import com.company.forest.organisms.animals.ExampleHerbivorous
import com.company.forest.organisms.trees.ExampleTree
import com.company.forest.util.Observer
import com.company.view.signals.AnimalNumberBox
import com.company.view.signals.TreeNumberBox
import tornadofx.*

class Statistics: View() {
    override val root = vbox {
        menubar {
            menu("Count animals") {
                item("Example Carnivorous").action { fire(AnimalNumberBox(Observer.countAnimals<ExampleCarnivorous>())) }
                item("Example Herbivorous").action { fire(AnimalNumberBox(Observer.countAnimals<ExampleHerbivorous>())) }
            }
            menu("Count trees") {
                item("Example Tree").action { fire(TreeNumberBox(Observer.countTrees<ExampleTree>())) }
            }
        }
        text {
            subscribe<AnimalNumberBox> { text = it.number.toString() }
        }
    }
}