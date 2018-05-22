package com.company.app

import com.company.view.*
import javafx.scene.image.Image
import javafx.stage.Stage
import org.junit.Test
import tornadofx.*
import java.io.File

class MyApp: App(MainView::class, Styles::class) {
    override fun start(stage: Stage) {
        super.start(stage)
        //stage.reloadViewsOnFocus()
        stage.isFullScreen = false
        stage.icons += Image(File("usages\\Icon.jpg").toURI().toString())
    }
}

class TestApp: App(TestView::class, Styles::class){
    override fun start(stage: Stage) {
        super.start(stage)
        reloadStylesheetsOnFocus()
        stage.isFullScreen = false
    }
}