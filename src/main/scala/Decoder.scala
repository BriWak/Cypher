import Cypher._

object Decoder {

  def apply(input: List[Int], key: Int): String = {
    val zipped = input.zip(expandKeys(key,input.length))
    val numWithKey = zipped.map(x => x._1 - x._2)
    numWithKey.map(digit => numberToLetter(digit)).mkString
  }

  def numberToLetter(input: Int): Char = (input + 96).toChar
}
