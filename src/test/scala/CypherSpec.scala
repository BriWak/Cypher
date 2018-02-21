import org.scalatest.{MustMatchers, WordSpec}

class CypherSpec extends WordSpec with MustMatchers {

  "Cypher" must {

    "return List(1) when given `a` and 0" in {
      Cypher("a", 0) mustEqual List(1)
    }

    "return List(1, 2) when given `ab` and 0" in {
      Cypher("ab", 0) mustEqual List(1, 2)
    }

    "return List(24, 25, 26) when given `xyz` and 0" in {
      Cypher("xyz", 0) mustEqual List(24, 25, 26)
    }

    "return List(2) when given `a` and 1" in {
      Cypher("a", 1) mustEqual List(2)
    }

    "return List(2, 3) when given `ab` and 1" in {
      Cypher("ab", 1) mustEqual List(2, 3)
    }

    "return List(2, 4) when given `ab` and 12" in {
      Cypher("ab", 12) mustEqual List(2, 4)
    }

    "return List(14,...2,8) when given 'masterpiece' and 1939" in {
      Cypher("masterpiece",1939) mustEqual List(14,10,22,29,6,27,19,18,6,12,8)
    }
  }

  "Letter to Number" must {
    "return 1 when given `a`" in {
      Cypher.letterToNumber('a') mustEqual 1
    }

    "return 26 when given `z`" in {
      Cypher.letterToNumber('z') mustEqual 26
    }
  }

  "Split Key" must {

    "return List(1) when given 1" in {
      Cypher.splitKeys("1") mustEqual List(1)
    }

    "return List(1, 2) when given 12" in {
      Cypher.splitKeys("12") mustEqual List(1, 2)
    }
  }

  "Expand keys" must {
    "return List(1, 2, 1, 2) when given List(1, 2) and length 4" in {
      Cypher.expandKeys(12, 4) mustEqual List(1, 2, 1, 2)
    }

    "return List(2, 1, 2, 1) when given List(2, 1) and length 4" in {
      Cypher.expandKeys(21, 4) mustEqual List(2, 1, 2, 1)
    }

    "return List(2, 1, 2, 1, 2) when given List(2,1) and length 5" in {
      Cypher.expandKeys(21,5) mustEqual List(2, 1, 2, 1, 2)
    }
  }
}