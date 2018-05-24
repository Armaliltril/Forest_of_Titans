package com.company.view

import com.company.experimental.animal.AnimalType
import com.company.experimental.tree.TreeType
import com.company.forest.util.Observer
import com.company.view.signals.AnimalNumberBox
import com.company.view.signals.TreeNumberBox
import tornadofx.*

class Statistics: View() {
    override val root = vbox {
        title = "Statistics"
        menubar {
            menu("Count animals") {
                item("Animals").action { fire(AnimalNumberBox(Observer.countAllAnimals())) }
                item("Badgers").action { fire(AnimalNumberBox(Observer.countAnimals(AnimalType.BADGER))) }
                item("Chipmunk").action { fire(AnimalNumberBox(Observer.countAnimals(AnimalType.CHIPMUNK))) }
                item("Flying Squirrel").action { fire(AnimalNumberBox(Observer.countAnimals(AnimalType.FLYING_SQUIRREL))) }
                item("Squirrel").action { fire(AnimalNumberBox(Observer.countAnimals(AnimalType.SQUIRREL))) }
                item("Woodpecker").action { fire(AnimalNumberBox(Observer.countAnimals(AnimalType.WOODPECKER))) }
                item("Vulture").action { fire(AnimalNumberBox(Observer.countAnimals(AnimalType.VULTURE))) }
                item("Wolf").action { fire(AnimalNumberBox(Observer.countAnimals(AnimalType.WOLF))) }
            }
            menu("Count trees") {
                item("Trees").action { fire(TreeNumberBox(Observer.countAllTrees())) }
                item("Birch").action { fire(TreeNumberBox(Observer.countTrees(TreeType.BIRCH))) }
                item("Hazel").action { fire(TreeNumberBox(Observer.countTrees(TreeType.HAZEL))) }
                item("Maple").action { fire(TreeNumberBox(Observer.countTrees(TreeType.MAPLE))) }
                item("Oak").action { fire(TreeNumberBox(Observer.countTrees(TreeType.OAK))) }
                item("Pine").action { fire(TreeNumberBox(Observer.countTrees(TreeType.PINE))) }
                item("Spruce").action { fire(TreeNumberBox(Observer.countTrees(TreeType.SPRUCE))) }
            }
        }
        vbox {
            hbox {
                text("Number of chosen animals: ").addClass("text")
                text { subscribe<AnimalNumberBox> { text = it.number.toString() } }.addClass("text")
            }
            hbox {
                text("Number of chosen trees").addClass("text")
                text { subscribe<TreeNumberBox> { text = it.number.toString() } }.addClass("text")
            }
        }
    }
}