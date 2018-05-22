package com.company.view

import com.company.forest.Forest
import com.company.forest.InProgress
import com.company.view.signals.UpdateSignal
import javafx.scene.media.AudioClip
import tornadofx.*
import java.io.File
import kotlin.concurrent.fixedRateTimer
import kotlin.concurrent.timerTask

class TopMenu : View() {
    private val musicList = arrayListOf("Bleu", "Grasswalk", "Living Mice", "Loonboon", "Wet Hands")

    override val root = vbox {
        menubar {
            menu("Controls") {
                item("Start").action {
                    fire(UpdateSignal(true))
                }
                item("Stop").action {
                    fire(UpdateSignal(false))
                }
            }
            menu("Tooltips") {
                item("Paint Tooltips").action {
                    find(PaintTooltips::class).openModal()
                }
                item("Tutorial").action {
                    find(Tutorial::class).openModal()
                }
            }
            menu("Statistics") {
                item("Open statistics").action {
                    find(Statistics::class).openModal()
                }
            }
            menu("Music") {
                lateinit var clip: AudioClip

                menu("Play track") {
                    for (track in musicList) {
                        item(track).action {
                            clip = getAudioClip(track)
                            clip.play()
                        }
                    }
                }
                item("Stop").action {
                    clip.stop()
                }
            }
        }
    }

    private fun getAudioClip(name: String): AudioClip {
        return when(name) {
            "Bleu" -> AudioClip(File("usages/Bleu.mp3").toURI().toString())
            "Grasswalk" -> AudioClip(File("usages/Grasswalk.mp3").toURI().toString())
            "Living Mice" -> AudioClip(File("usages/Living Mice.mp3").toURI().toString())
            "Loonboon" -> AudioClip(File("usages/Loonboon.mp3").toURI().toString())
            "Wet Hands" -> AudioClip(File("usages/Wet Hands.mp3").toURI().toString())
            else -> throw RuntimeException("Wrong audio-file name")
        }
    }
}
