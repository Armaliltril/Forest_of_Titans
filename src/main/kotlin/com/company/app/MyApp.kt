package com.company.app

import com.company.view.ForestGrid
import com.company.view.Intro
import com.company.view.MainView
import javafx.scene.image.Image
import javafx.stage.Stage
import tornadofx.*
import java.io.File

class MyApp: App(Intro::class, Styles::class) {
    override fun start(stage: Stage) {
        super.start(stage)
        stage.reloadViewsOnFocus()
        stage.isFullScreen = false
        stage.icons += Image(File("usages\\Icon.jpg").toURI().toString())
    }
}

class TestApp: App(ForestGrid::class)