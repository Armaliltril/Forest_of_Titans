package com.company.view

import com.company.experimental.animal.Animal
import com.company.experimental.animal.AnimalData
import com.company.forest.InProgress
import com.company.view.signals.AnimalBox
import javafx.beans.property.SimpleStringProperty
import javafx.scene.text.FontWeight
import tornadofx.*

class AnimalView : View() {
    var name =  SimpleStringProperty()
    var stamina = SimpleStringProperty()
    var health = SimpleStringProperty()
    var age = SimpleStringProperty()
    var hunger = SimpleStringProperty()

    @InProgress override val root = vbox {
        subscribe<AnimalBox> { updateProperties(it.animal) }

        setMinSize(100.0, 150.0)

        text {
            bind(name)
            style{fontWeight = FontWeight.BOLD}

        }
        text().bind(stamina)
        text().bind(health)
        text().bind(age)
        text().bind(hunger)
    }

    private fun updateProperties(animal: AnimalData) {
        name.value = animal.name
//        stamina.value = "Stamina: " + animal.stamina.toString()
        health.value = "Health: " + animal.health.toString() + "/" + animal.maxHealth.toString()
        age.value = "Age: " + animal.age.toString() + "/" + animal.maxAge.toString()
        hunger.value = "Hunger: " + animal.hunger.toString()
    }
}
