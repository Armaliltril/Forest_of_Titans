package com.company.view

import com.company.forest.InProgress
import tornadofx.*

@InProgress
class ForestSetter: View() {
    override val root = vbox {
        //Just a filler
        title = "Forest of Titans"
        slider(0, 100)
        button("Continue") {
            action {
                replaceWith(find(MainView::class))
            }
        }
    }
}