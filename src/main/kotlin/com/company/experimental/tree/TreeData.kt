package com.company.experimental.tree

import com.company.experimental.animal.Animal
import com.company.experimental.animal.AnimalData
import java.lang.Integer.min
import java.util.*

class TreeData {
    lateinit var behavior: Tree
        private set

    var foodFrequency: Int = 10
        private set

    var maxFood: Int = 0
        private set

    var xPosition: Int = 0
        private set

    var yPosition: Int = 0
        private set

    var foodPause: Int = 0
        private set

    var food: Int = 0
        private set

    var isAlive = true
        private set

    var foodPerTime: Int = 1
        private set

    class Builder {
        private val treeData: TreeData = TreeData()

        fun setFoodFrequency(param: Int): Builder {
            treeData.foodFrequency = param
            return this
        }

        fun setFoodPerTime(param: Int): Builder {
            treeData.foodPerTime = param
            return this
        }

        fun setMaxFood(param: Int): Builder {
            treeData.maxFood = param
            return this
        }

        fun setYPosition(param: Int): Builder {
            treeData.yPosition = param
            return this
        }

        fun setXPosition(param: Int): Builder {
            treeData.xPosition = param
            return this
        }

        fun setBehavior(tree: Tree): Builder {
            treeData.behavior = tree
            return this
        }

        fun build(): TreeData {
            treeData.food = treeData.maxFood / 2
            treeData.foodPause = 0
            return treeData
        }
    }


    class TreeHerald : TreeBehavior {
        var rnd = Random()

        lateinit var behavior: Tree
        lateinit var data: TreeData

        fun associateWith(behavior: Tree, data: TreeData) {
            this.behavior = behavior
            this.data = data
        }

        fun tick() {
            if (data.isAlive) {
                behavior.tick()
            }
        }

        fun getInfo(): TreeData {
            return data
        }

        override fun produce() {
            if (data.foodPause == data.foodFrequency){
                data.food = min(data.maxFood, data.food + data.foodPerTime)
                data.foodPause = 0
            }
            else{
                data.foodPause += 1
            }
        }
    }
}