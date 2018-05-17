package com.company.view

import com.company.forest.InProgress
import tornadofx.*

class TopMenu: View() {
    override val root = vbox {
        menubar {
            menu("Controls") {
                @InProgress item("Start").action {
                    println("Pretending Start")
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
