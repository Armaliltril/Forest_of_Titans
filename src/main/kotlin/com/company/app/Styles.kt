package com.company.app

import javafx.scene.text.FontWeight
import tornadofx.Stylesheet
import tornadofx.box
import tornadofx.cssclass
import tornadofx.px

class Styles : Stylesheet() {
    init {
        label {
            padding = box(10.px)
            fontSize = 20.px
            fontWeight = FontWeight.MEDIUM
        }
    }
}