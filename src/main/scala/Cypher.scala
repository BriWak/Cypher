object Cypher {

  def apply(input: String, key: Int): List[Int] = {
    val initialNumbers: List[Int] = input.map(char => letterToNumber(char)).toList
    val zipped = initialNumbers.zip(expandKeys(key,initialNumbers.length))
    zipped.map(x => x._1 + x._2)
  }

  def letterToNumber(input: Char): Int = input.toInt - 96

  def splitKeys(key: String): List[Int] =
    key.map(x => x.asDigit).toList

  def expandKeys(keys: Int, length: Int): List[Int] = {
    val keyString = keys.toString
    val keyLength = keyString.length
    val timesToRepeat = length / keyLength
    val remainder = length % keyLength
    splitKeys(keyString*timesToRepeat + keyString.substring(0,remainder))
  }
}