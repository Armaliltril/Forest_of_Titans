package com.company.view.signals

import tornadofx.*

class TreeNumberBox(val number: Int): FXEvent(EventBus.RunOn.BackgroundThread)
