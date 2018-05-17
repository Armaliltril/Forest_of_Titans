package com.company.experimental

abstract class BaseBehavior: Animal{
    lateinit var herald: AnimalData.Herald

    override fun associateWith(herald: AnimalData.Herald) {
        this.herald = herald
    }
}