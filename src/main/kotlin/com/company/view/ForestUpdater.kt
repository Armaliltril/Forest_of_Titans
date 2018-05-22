package com.company.view

import com.company.view.signals.UpdateSignal
import tornadofx.*
import java.util.*
import kotlin.concurrent.fixedRateTimer
import kotlin.concurrent.timer
import kotlin.concurrent.timerTask

class ForestUpdater: View() {
    private val forestModel = ForestModel()
    private val task = timerTask { forestModel.update() }
    private lateinit var timer: Timer

    override val root = hbox {
        setMaxSize(0.0, 0.0)
        subscribe<UpdateSignal> {
            when(it.isUpdating) {
                true -> timer = fixedRateTimer("Forest Update Timer", true, 0, 60, {task.run()})
                false -> if (::timer.isInitialized) timer.cancel()
            }
        }
    }
}