package com.company.forest.organisms.trees

import com.company.forest.InProgress
import com.company.forest.organisms.Organism

abstract class Tree: Organism() {
    @InProgress abstract class PartOfTree() {
        abstract val capacity: Int
    }
    @InProgress abstract inner class Crown(): PartOfTree() {
        override val capacity = 5
    }
    @InProgress abstract inner class Trunk(): PartOfTree() {
        override val capacity = 5
    }
    @InProgress inner class Roots(): PartOfTree() {
        override val capacity = 7
    }


}