package com.company.view

import com.company.forest.InProgress
import tornadofx.*

class TopMenu: View() {
    override val root = menubar {
        menu("Tooltips") {
            @InProgress item("Show Tooltips", "Shortcut+T").action {
                println("Pretending that there is tooltips")
            }
        }
    }
}