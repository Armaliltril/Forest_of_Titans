package com.company.view

import com.company.experimental.animal.example.StupidAnimal
import com.company.experimental.tree.example.StupidTree
import com.company.forest.InProgress
import tornadofx.*

@InProgress
class PaintTooltips: View() {
    override val root = hbox {
        vbox {
            label("Animals:")
            hbox {
                label("Example Carnivorous: ")
                circle {
                    radius = 6.0
                    fill = StupidAnimal().getColor()
                }
            }
            hbox {
                label("Example Herbivorous: ")
                circle {
                    radius = 6.0
                    fill = StupidAnimal().getColor()
                }
            }
        }
        vbox {
            label("Trees:")
            hbox {
                label("Example Tree: ")
                rectangle {
                    height = 12.0
                    width = 12.0
                    fill = StupidTree().getColor()
                }
            }
        }
    }
}