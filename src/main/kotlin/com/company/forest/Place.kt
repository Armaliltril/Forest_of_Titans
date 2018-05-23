package com.company.forest

import javafx.scene.paint.Color

open class Place: Drawable {
    override var color: Color
        get() = throw RuntimeException("Assign to semi-abstract Place")
        set(value) {Color.LIGHTGRAY}
}
