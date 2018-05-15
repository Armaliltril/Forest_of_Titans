package com.company.forest.organisms.trees

import com.company.forest.InProgress
import java.util.*

object TreeFactory {
    @InProgress fun getRandomTree(): Tree {
        return when (Random().nextInt(1)) {
            0 -> ExampleTree()
            else -> throw RuntimeException()
        }
    }
}