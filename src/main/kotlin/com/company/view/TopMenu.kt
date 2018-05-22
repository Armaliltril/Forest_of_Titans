package com.company.view

import com.company.forest.Forest
import com.company.forest.InProgress
import com.company.view.signals.UpdateSignal
import tornadofx.*
import kotlin.concurrent.fixedRateTimer
import kotlin.concurrent.timerTask

class TopMenu : View() {
    override val root = vbox {
        menubar {
            menu("Controls") {
                item("Start").action {
                    fire(UpdateSignal(true))
                }

                item("Stop").action {
                    fire(UpdateSignal(false))
                }

                //TODO Is it even works?
                tooltip("Controls executions of Forest model")
            }
            menu("Tooltips") {
                item("Paint Tooltips").action {
                    find(PaintTooltips::class).openModal()
                }
                item("Tutorial").action {
                    find(Tutorial::class).openModal()
                }
            }
            menu("Statistics") {
                item("Open statistics").action {
                    find(Statistics::class).openModal()
                }
            }
        }
    }
}
