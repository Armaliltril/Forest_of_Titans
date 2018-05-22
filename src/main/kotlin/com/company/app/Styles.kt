package com.company.app

import javafx.scene.text.FontWeight
import tornadofx.Stylesheet
import tornadofx.box
import tornadofx.cssclass
import tornadofx.px

class Styles : Stylesheet() {
    companion object {
        val sampleButton by cssclass()
        val sampleText by cssclass()
    }

    init {
        s(text, label, button, menu) {
            padding = box(5.px)
            fontSize = 22.px
            fontWeight = FontWeight.MEDIUM
        }
    }
}