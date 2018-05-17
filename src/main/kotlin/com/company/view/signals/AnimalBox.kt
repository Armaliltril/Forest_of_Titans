package com.company.view.signals

import com.company.experimental.animal.Animal
import com.company.experimental.animal.AnimalData
import tornadofx.*

class AnimalBox(val animal: AnimalData): FXEvent(EventBus.RunOn.BackgroundThread)