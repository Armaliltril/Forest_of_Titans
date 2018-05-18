package com.company.experimental.animal

import com.company.experimental.Rotations
import javafx.scene.paint.Color
import com.company.forest.Place



interface AnimalBehavior{
    fun goAhead() : Boolean

    fun turnAround(rotation: Rotations): Boolean

    fun eat(place: Place) : Boolean

    fun fight(place: Place) : Boolean

    fun regenerate() : Boolean

    fun reproduce(place: Place) : Boolean

    fun askExtraTurn() : Boolean

    fun seeEnemies(): List<Place>

    fun seeFood(): List<Place>

    fun seeFriends(): List<Place>
}