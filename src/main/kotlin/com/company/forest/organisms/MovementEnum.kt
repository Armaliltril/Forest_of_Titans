package com.company.forest.organisms

enum class Directions(val value: Pair<Int, Int>){
    UP(Pair(-1, 0)), RIGHT(Pair(0, 1)), DOWN(Pair(1, 0)), LEFT(Pair(0, -1));
}

enum class Rotations{
    LEFT, RIGHT
}