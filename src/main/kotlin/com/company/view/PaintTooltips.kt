package com.company.view

import com.company.forest.organisms.animal.types.*
import com.company.forest.organisms.tree.types.*
import com.company.forest.InProgress
import javafx.scene.text.FontWeight
import tornadofx.*

@InProgress
class PaintTooltips: View() {
    override val root = hbox {
        title = "Paint tooltips"
        vbox {
            label("Animals:")

            label("Herbivorous") {
                style {
                    fontWeight = FontWeight.BOLD
                }
            }
            hbox {
                label("Badger: ")
                circle {
                    radius = 12.0
                    fill = Badger().getColor()
                }
            }
            hbox {
                label("Chipmunk: ")
                circle {
                    radius = 12.0
                    fill = Chipmunk().getColor()
                }
            }
            hbox {
                label("Flying Squirrel: ")
                circle {
                    radius = 12.0
                    fill = FlyingSquirrel().getColor()
                }
            }
            hbox {
                label("Squirrel: ")
                circle {
                    radius = 12.0
                    fill = Squirrel().getColor()
                }
            }
            hbox {
                label("Woodpecker: ")
                circle {
                    radius = 12.0
                    fill = Woodpecker().getColor()
                }
            }
            label("Carnivorous") {
                style {
                    fontWeight = FontWeight.BOLD
                }
            }
            hbox {
                label("Vulture: ")
                circle {
                    radius = 12.0
                    fill = StupidAnimal().getColor()
                }
            }
            hbox {
                label("Wolf: ")
                circle {
                    radius = 12.0
                    fill = StupidAnimal().getColor()
                }
            }
        }
        vbox {
            label("Trees:")
            hbox {
                label("Birch: ")
                rectangle {
                    height = 24.0
                    width = 24.0
                    fill = Birch().getColor()
                }
            }
            hbox {
                label("Hazel: ")
                rectangle {
                    height = 24.0
                    width = 24.0
                    fill = Maple().getColor()
                }
            }
            hbox {
                label("Oak: ")
                rectangle {
                    height = 24.0
                    width = 24.0
                    fill = Oak().getColor()
                }
            }
            hbox {
                label("Pine: ")
                rectangle {
                    height = 24.0
                    width = 24.0
                    fill = Pine().getColor()
                }
            }
            hbox {
                label("Spruce: ")
                rectangle {
                    height = 24.0
                    width = 24.0
                    fill = Spruce().getColor()
                }
            }
        }
    }
}