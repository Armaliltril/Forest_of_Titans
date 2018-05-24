package com.company.experimental.tree

import java.util.*

class TreeData {
    lateinit var behavior: Tree
        private set

    var name = ""

    var xPosition: Int = 0
        private set

    var yPosition: Int = 0
        private set

    var isAlive = true
        private set

    var foodPause: Int = 0
        private set

    var foodSpawnFrequency: Int = 10
        private set

    var foodPerTime: Int = 5
        private set

    val treeFood =  TreeFood(0, 0, 0, 0, 0, 0)

    class Builder {
        private val treeData: TreeData = TreeData()

        fun setName(param: String): Builder {
            treeData.name = param
            return this
        }

        fun setFoodFrequency(param: Int): Builder {
            treeData.foodSpawnFrequency = param
            return this
        }

        fun setFoodPerTime(param: Int): Builder {
            treeData.foodPerTime = param
            return this
        }

        fun setMaxFoodAndFood(maxOnCrown: Int, maxOnTrump: Int, maxOnRoots: Int): Builder {
            treeData.treeFood.maxOnCrown = maxOnCrown
            treeData.treeFood.maxOnTrunk = maxOnTrump
            treeData.treeFood.maxOnRoots = maxOnRoots

            val random = Random()

            treeData.treeFood.onCrown = maxOnCrown - random.nextInt(maxOnCrown / 2)
            treeData.treeFood.onTrunk = maxOnTrump - random.nextInt(maxOnTrump / 2)
            treeData.treeFood.onRoots = maxOnRoots - random.nextInt(maxOnRoots / 2)

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
            treeData.foodPause = 0
            return treeData
        }
    }

    class TreeHerald : TreeBehavior {

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

        fun getInfo() = data

        override fun produceFood() {
            if (data.foodPause == data.foodSpawnFrequency){
                data.treeFood.produce(data.foodPerTime)
                data.foodPause = 0
            }
            else{
                data.foodPause += 1
            }
        }
    }
}