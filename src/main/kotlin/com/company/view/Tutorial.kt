package com.company.view

import tornadofx.*

class Tutorial: View() {
    override val root = vbox {
        title = "Tutorial"
        text("Some text for tutorial").addClass("text")
    }
}