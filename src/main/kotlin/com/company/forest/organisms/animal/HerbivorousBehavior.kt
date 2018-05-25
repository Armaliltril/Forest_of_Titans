package com.company.forest.organisms.animal

import com.company.forest.InProgress
import com.company.forest.organisms.Rotations
import com.company.forest.util.Random

abstract class HerbivorousBehavior: BaseAnimalBehavior() {
    @InProgress
    override fun tick() {
        seeFront()

        if (isHungry(30)) {
            if (!eat()) {
                if(!goAhead())
                    when (Random.happenWithChance(50)) {
                        true -> turnAround(Rotations.LEFT)
                        false -> turnAround(Rotations.RIGHT)
                    }
            }
        }
        if (isTired(50) || isDamaged(50)) {
            rest()
        }
        if (isDamaged(80)) {
            rest()
        }
    }

}