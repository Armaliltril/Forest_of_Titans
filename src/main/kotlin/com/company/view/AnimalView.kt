package com.company.view

import com.company.forest.InProgress
import com.company.forest.organisms.animals.Animal
import com.company.forest.organisms.animals.AnimalFactory
import com.company.view.signals.AnimalBox
import javafx.beans.property.SimpleObjectProperty
import javafx.beans.property.SimpleStringProperty
import javafx.scene.paint.Color
import javafx.scene.text.FontWeight
import tornadofx.*
import kotlin.math.max

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

        //TODO MindMap
    }

    private fun updateProperties(animal: Animal) {
        name.value = animal.name
        stamina.value = "Stamina: " + animal.stamina.toString()
        health.value = "Health: " + animal.health.toString() + "/" + animal.maxHealth.toString()
        age.value = "Age: " + animal.age.toString() + "/" + animal.maxAge.toString()
        hunger.value = "Hunger: " + animal.hunger.toString()
    }
}
