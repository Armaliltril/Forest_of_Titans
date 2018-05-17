package tests.forest

import com.company.forest.Forest
import com.company.forest.PlaceWithTree
import com.company.forest.PlaceWithoutTree
import com.company.forest.util.Observer
import io.kotlintest.shouldBe
//
//class ObserverTest: FunSpec({
//    test("Observer should count animals right") {
//        var counter = 0
//        Forest.places.forEach { it.forEach { if (it is PlaceWithoutTree) {
//            it.animal = ExampleCarnivorous()
//            counter++
//        }} }
//        Observer.countAnimals<ExampleCarnivorous>() shouldBe counter
//    }
//    test("Observer shold count trees right") {
//        val fillerTree = ExampleTree()
//        Forest.places.forEach { it.forEach { if (it is PlaceWithTree) it.tree = fillerTree} }
//        Observer.countTrees<ExampleTree>() shouldBe 1
//    }
//})
