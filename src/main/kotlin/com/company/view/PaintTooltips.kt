package com.company.view

import com.company.forest.InProgress
import com.company.forest.organisms.animals.ExampleCarnivorous
import com.company.forest.organisms.animals.ExampleHerbivorous
import com.company.forest.organisms.trees.ExampleTree
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
                    fill = ExampleCarnivorous().color
                }
            }
            hbox {
                label("Example Herbivorous: ")
                circle {
                    radius = 6.0
                    fill = ExampleHerbivorous().color
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
                    fill = ExampleTree().color
                }
            }
        }
    }
}