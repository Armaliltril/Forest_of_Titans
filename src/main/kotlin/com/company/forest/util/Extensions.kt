package com.company.forest.util

fun <T> makeArrayList(size: Int, filler: T): ArrayList<T> {
    val list = arrayListOf<T>()
    for (i in 0 until size) list.add(filler)
    return list
}