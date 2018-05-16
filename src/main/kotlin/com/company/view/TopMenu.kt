package com.company.view

import com.company.forest.InProgress
import tornadofx.*

class TopMenu: View() {
    override val root = menubar {
        menu("Tooltips") {
            item("Paint Tooltips").action {
                openInternalWindow(PaintTooltips::class)
            }
            item("Tutorial").action {
                openInternalWindow(Tutorial::class)
            }
        }
    }
}