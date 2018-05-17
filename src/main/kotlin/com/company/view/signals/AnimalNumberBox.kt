package com.company.view.signals

import tornadofx.*

class AnimalNumberBox(val number: Int): FXEvent(EventBus.RunOn.BackgroundThread)
