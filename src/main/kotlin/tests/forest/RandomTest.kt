package tests.forest

import io.kotlintest.specs.FunSpec
import com.company.forest.util.Random
import io.kotlintest.shouldBe
import io.kotlintest.forAll
import io.kotlintest.matchers.beEmpty
import io.kotlintest.shouldNot

class RandomTest: FunSpec( {
    test("Chances should be veritable") {
        Random.happenWithChance(0) shouldBe false
        Random.happenWithChance(100) shouldBe true
    }
    test("Tree centers should be within the borders") {
        val centers = Random.defineTreePlaces(1000)
        forAll(centers, {(it.first in 2..998 && it.second in 2..998) shouldBe true})
    }
    test ("Tree (centers) should be generated") {
        val centers = Random.defineTreePlaces(1000)
        centers.shouldNot(beEmpty())
    }
})