package com.company.view

import tornadofx.*

class Intro: View() {
    override val root = vbox {
        title = "Forest of Titans"
        label ("Hello and welcome to The Forest")
        button ("Continue"){
            action {
                replaceWith(find(MainView::class))
            }
        }
    }
}