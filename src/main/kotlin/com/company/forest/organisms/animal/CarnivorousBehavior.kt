package com.company.forest.organisms.animal

import com.company.forest.InProgress
import com.company.forest.organisms.Rotations
import com.company.forest.util.Random

abstract class CarnivorousBehavior: BaseAnimalBehavior() {
    @InProgress
    override fun tick() {
        if (isHungry(20)) {
            if (!eat()) {
                if(!goAhead())
                    when (Random.happenWithChance(50)) {
                        true -> turnAround(Rotations.LEFT)
                        false -> turnAround(Rotations.RIGHT)
                    }
            }
        }

        if (isTired(50) || isDamaged(60)) {
            rest()
        }
        if (isDamaged(80)) {
            rest()
        }
    }

}