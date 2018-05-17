package com.company.view

import com.company.view.signals.UpdateSignal
import tornadofx.*
import kotlin.concurrent.fixedRateTimer
import kotlin.concurrent.timerTask

class ForestUpdater: View() {
    val forestModel = ForestModel()
    override val root = hbox {
        setMaxSize(0.0, 0.0)
        subscribe<UpdateSignal> { forestModel.update() }
    }
}