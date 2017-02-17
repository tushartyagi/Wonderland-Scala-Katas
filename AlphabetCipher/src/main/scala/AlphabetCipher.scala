object AlphabetCipher {

  /** Looks for the combination of row and col in the substitution chart*/
  def offset(col: Char, row: Char): Char = {
    val shiftedPosition = row.toInt - 'a'.toInt
    (col.toInt + shiftedPosition).toChar
  }

  /** Attaches the string to itself until it has the proper size */
  def padding(keyword: String, size: Int): String = {
    paddingHelper(keyword, keyword, keyword.length, size - keyword.length)
  }

  def paddingHelper(keyword: String, stringSoFar: String,
    sizeSoFar: Int, sizeRemaining: Int): String = {
    if (sizeRemaining == 0) stringSoFar
    else {
      if (sizeRemaining >= keyword.length)
        paddingHelper(keyword, stringSoFar + keyword,
          sizeSoFar - keyword.length, sizeRemaining - keyword.length)
      else {
        paddingHelper(keyword, stringSoFar + keyword.substring(0, sizeRemaining),
        sizeSoFar - sizeRemaining, 0)
      }
    }
  }


  def encode(keyword: String, message: String): String = {
    ??? //keyword
  }

  def decode(keyword: String, message: String): String = {
    ??? //keyword
  }

  def decipher(cipher: String, message: String): String = {
    ??? //cipher
  }

}
