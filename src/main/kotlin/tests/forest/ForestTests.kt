package tests.forest

import com.company.forest.Forest
import com.company.forest.PlaceWithTree
import com.company.forest.PlaceWithoutTree
import io.kotlintest.specs.FunSpec
import io.kotlintest.shouldBe
import io.kotlintest.matchers.gte

class ForestTests: FunSpec( {
    test("Animals should spawn") {
        var counter = 0
        Forest.places.forEach { it.forEach { if (it is PlaceWithoutTree && it.animal != null) counter++ } }
        counter shouldBe gte(1)
    }
    test("Trees should spawn") {
        var counter = 0
        Forest.places.forEach { it.forEach { if (it is PlaceWithTree) counter++} }
        counter shouldBe gte(1)
    }
} )
