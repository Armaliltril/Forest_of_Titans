package com.company.experimental

abstract class BaseAnimalBehavior : Animal{
    lateinit var herald: AnimalData.AnimalHerald

    override fun associateWith(herald: AnimalData.AnimalHerald) {
        this.herald = herald
    }
}