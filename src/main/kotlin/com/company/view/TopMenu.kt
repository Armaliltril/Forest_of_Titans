package com.company.view

import com.company.forest.Forest
import com.company.forest.InProgress
import tornadofx.*

class TopMenu : View() {
    lateinit var thread: Thread
    override val root = vbox {
        menubar {
            menu("Controls") {
                @InProgress item("Start").action {
//                    println("Pretending Start")
////                    thread = Thread(Forest.core::run)
////                    thread.start()
//                    var lastTime = System.currentTimeMillis()
//                    while (true) {
//                        if (System.currentTimeMillis() - lastTime > 1000) {
//                            val a = find(Updater::class).openModal()
//                            a!!.close()
//                            lastTime = System.currentTimeMillis()
//                        }
//                    }
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
