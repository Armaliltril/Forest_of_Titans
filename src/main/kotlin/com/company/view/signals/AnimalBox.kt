package com.company.view.signals

import com.company.forest.organisms.animal.AnimalData
import tornadofx.*

class AnimalBox(val animal: AnimalData): FXEvent(EventBus.RunOn.BackgroundThread)