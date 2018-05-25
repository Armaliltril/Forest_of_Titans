package com.company.view.signals

import com.company.forest.organisms.tree.TreeData
import tornadofx.*

class TreeBox(val tree: TreeData): FXEvent(EventBus.RunOn.BackgroundThread)