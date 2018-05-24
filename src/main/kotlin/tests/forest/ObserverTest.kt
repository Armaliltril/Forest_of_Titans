package tests.forest

import com.company.experimental.animal.AnimalData
import com.company.experimental.animal.AnimalType
import com.company.experimental.animal.example.Badger
import com.company.experimental.animal.example.StupidAnimal
import com.company.experimental.tree.TreeData
import com.company.experimental.tree.TreeType
import com.company.experimental.tree.example.Birch
import com.company.forest.Forest
import com.company.forest.PlaceWithTree
import com.company.forest.PlaceWithoutTree
import com.company.forest.util.Observer
import io.kotlintest.shouldBe
import io.kotlintest.specs.FunSpec

class ObserverTest: FunSpec({
    test("Observer should count animals right") {
        var counter = 0
        Forest.places.forEach { it.forEach { if (it is PlaceWithoutTree && it.animal != null) {
            counter++
        }} }
        Observer.countAllAnimals() shouldBe counter
    }
    test("Observer should count trees right") {
        val fillerTree = TreeData()
        Forest.places.forEach { it.forEach { if (it is PlaceWithTree) it.tree = fillerTree} }
        Observer.countAllTrees() shouldBe 1
    }
    test("Observer should count animals by type") {
        var counter = 0
        Forest.places.forEach { it.forEach { if (it is PlaceWithoutTree) it.animal = Badger().createData(0, 0) } }
        Observer.countAnimals(AnimalType.BADGER) shouldBe Observer.countAllAnimals()
    }
    test("Observer should count trees by type") {
        val fillerTree = Birch().createData(0, 0)
        Forest.places.forEach { it.forEach { if (it is PlaceWithTree) it.tree = fillerTree} }
        Observer.countTrees(TreeType.BIRCH) shouldBe 1
    }
})
