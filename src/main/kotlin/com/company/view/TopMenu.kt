package com.company.view

import com.company.forest.Forest
import com.company.forest.InProgress
import javafx.animation.AnimationTimer
import tornadofx.*

class TopMenu : View() {
    lateinit var thread: Thread
    override val root = vbox {
        menubar {
            menu("Controls") {
                @InProgress item("Start").action {
                    Forest.timer?.stop()

                    Forest.timer = object : AnimationTimer() {
                        private var oldNow: Long = 0

                        override fun handle(now: Long) {
                            if (oldNow == 0L) {
                                oldNow = now
                            }
                            if ((now - oldNow) > 1000000) {
                                // Запускаем тик
                                Forest.core.tick()
                            }
                        }
                    }
                    Forest.timer!!.start()
                }

                @InProgress item("Stop").action {
                    Forest.timer?.stop()
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
