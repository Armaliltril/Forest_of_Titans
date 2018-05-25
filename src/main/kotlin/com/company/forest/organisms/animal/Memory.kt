package com.company.forest.organisms.animal

import com.company.forest.organisms.tree.TreeData
import com.company.forest.Place

class Memory{
    var place : Place
    var type: Char = ' '
    var time: Int = 0

    var animalData: AnimalData? = null
    var treeData: TreeData? = null

    constructor(place: Place, animalData: AnimalData?, treeData: TreeData?){
        this.place = place
        this.animalData = animalData
        this.treeData = treeData

        time = 5
        when {
            animalData != null -> type = 'a'
            treeData != null -> type = 't'
            else -> type = 'e'
        }
    }

    fun isSame(otherAnimalData: AnimalData?) = animalData === otherAnimalData

    fun isSame(otherTreeData: TreeData?) = treeData === otherTreeData

    fun updatePlace(place: Place){
        this.place = place
        time = 5
    }

    fun goTime(){
        time -= 1
    }
}