package com.company.view

import com.company.forest.InProgress
import com.company.forest.organisms.animals.Animal
import com.company.forest.organisms.animals.AnimalFactory
import com.company.view.signals.AnimalBox
import tornadofx.*

class AnimalView : View() {
    var animal: Animal = AnimalFactory.getRandomAnimal()
    @InProgress override val root = vbox {
        subscribe<AnimalBox> { animalBox -> animal = animalBox.animal }

        label (animal.name)
        label("Power: " + animal.power)
        label("Stamina: " + animal.stamina)
        label("Health: " + animal.health + "/" + animal.maxHealth)
        label("Age: " + animal.age + "/" + animal.maxAge)
        label("Hunger: " + animal.hunger + "/100")

        //TODO MindMap
    }
}
