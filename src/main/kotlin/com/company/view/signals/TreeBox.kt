package com.company.view.signals

import com.company.experimental.tree.TreeData
import tornadofx.*

class TreeBox(val tree: TreeData): FXEvent(EventBus.RunOn.BackgroundThread)