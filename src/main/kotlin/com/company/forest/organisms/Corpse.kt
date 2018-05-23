package com.company.forest.organisms

import com.company.forest.Removable
import com.company.forest.InProgress

@InProgress class Corpse(private val initialMeatAmount: Int): IEatable, Removable {
    var currentMeatAmount = initialMeatAmount
    fun decay() {
        currentMeatAmount -= initialMeatAmount / 4
        tryRemove()
    }

    override fun tryRemove() {
        if (currentMeatAmount <= 0) super.tryRemove()
    }
}