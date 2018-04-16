import org.scalatest.{MustMatchers, WordSpec}

class DecoderSpec extends WordSpec with MustMatchers {

  "Decoder" must {

    "return 'a' when given List(1) and 0" in {
      Decoder(List(1), 0) mustEqual "a"
    }

    "return 'ab' when given List(1, 2) and 0" in {
      Decoder(List(1, 2), 0) mustEqual "ab"
    }

    "return 'xyz' when given List(24, 25, 26) and 0" in {
      Decoder(List(24, 25, 26), 0) mustEqual "xyz"
    }

    "return 'a' when given List(2) and 1" in {
      Decoder(List(2), 1) mustEqual "a"
    }

    "return 'ab' when given List(2, 3) and 1" in {
      Decoder(List(2, 3), 1) mustEqual "ab"
    }

    "return ab when given List(2, 4) and 12" in {
      Decoder(List(2, 4), 12) mustEqual "ab"
    }

    "return 'masterpiece' when given List(14,10,22,29,6,27,19,18,6,12,8) and 1939" in {
      Decoder(List(14,10,22,29,6,27,19,18,6,12,8),1939) mustEqual "masterpiece"
    }
  }
}
