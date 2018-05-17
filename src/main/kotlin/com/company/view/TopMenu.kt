package com.company.view

import com.company.forest.InProgress
import tornadofx.*

class TopMenu: View() {
    override val root = vbox {
        menubar {
            menu("Tooltips") {
                item("Paint Tooltips").action {
                    openInternalWindow(PaintTooltips::class)
                }
                item("Tutorial").action {
                    openInternalWindow(Tutorial::class)
                }
            }
            menu("Statistics") {
                item("Open statistics").action {
                    openInternalWindow(Statistics::class)
                }
            }
        }
    }
}
