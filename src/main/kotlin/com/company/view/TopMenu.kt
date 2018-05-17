package com.company.view

import com.company.forest.Forest
import com.company.forest.InProgress
import com.company.view.signals.UpdateSignal
import tornadofx.*
import kotlin.concurrent.fixedRateTimer
import kotlin.concurrent.timerTask

class TopMenu : View() {
    lateinit var thread: Thread
    override val root = vbox {
        menubar {
            menu("Controls") {
                item("Start").action {
                    val task = timerTask { fire(UpdateSignal()) }
                    fixedRateTimer("Timer", true, 0, 500, {task.run()})
                }

                @InProgress item("Stop").action {
                    println("Pretending Stop")
                }
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
