package com.company.view

import com.company.forest.organisms.animal.AnimalData
import com.company.view.signals.AnimalBox
import javafx.beans.property.SimpleStringProperty
import javafx.scene.text.FontWeight
import tornadofx.*

class AnimalView : View() {
    private var name =  SimpleStringProperty()
    private var health = SimpleStringProperty()
    private var age = SimpleStringProperty()
    private var hunger = SimpleStringProperty()

    override val root = vbox {
        subscribe<AnimalBox> { updateProperties(it.animal) }

        setMinSize(150.0, 150.0)

        text {
            bind(name)
            style{fontWeight = FontWeight.BOLD}
        }
        text().bind(health)
        text().bind(age)
        text().bind(hunger)
    }

    private fun updateProperties(animal: AnimalData) {
        name.value = animal.name
        health.value = "Health: " + animal.health.toString() + "/" + animal.maxHealth.toString()
        age.value = "Age: " + animal.age.toString() + "/" + animal.maxAge.toString()
        hunger.value = "Hunger: " + animal.hunger.toString()
    }
}
