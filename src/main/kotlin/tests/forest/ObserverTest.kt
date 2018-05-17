package tests.forest

import com.company.forest.Forest
import com.company.forest.PlaceWithTree
import com.company.forest.PlaceWithoutTree
import com.company.forest.organisms.animals.ExampleCarnivorous
import com.company.forest.organisms.trees.ExampleTree
import com.company.forest.util.Observer
import io.kotlintest.specs.FunSpec
import io.kotlintest.shouldBe
import io.kotlintest.forAll
import io.kotlintest.matchers.beEmpty
import io.kotlintest.matchers.should
import io.kotlintest.shouldNot

class ObserverTest: FunSpec({
    test("Observer should count animals right") {
        var counter = 0
        Forest.places.forEach { it.forEach { if (it is PlaceWithoutTree) {
            it.animal = ExampleCarnivorous()
            counter++
        }} }
        Observer.countAnimals<ExampleCarnivorous>() shouldBe counter
    }
    test("Observer shold count trees right") {
        val fillerTree = ExampleTree()
        Forest.places.forEach { it.forEach { if (it is PlaceWithTree) it.tree = fillerTree} }
        Observer.countTrees<ExampleTree>() shouldBe 1
    }
})
