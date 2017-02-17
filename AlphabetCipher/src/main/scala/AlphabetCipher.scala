object AlphabetCipher {

  /** Looks for the combination of row and col in the substitution chart*/
  def offset(col: Char, row: Char): Char = {
    val shiftedRow = row.toInt - 'a'.toInt
    val shiftedCol = col.toInt - 'a'.toInt
    (((shiftedCol + shiftedRow) % 26) + 'a'.toInt).toChar
  }

  /** Attaches the string to itself until it has the proper size */
  def padding(keyword: String, size: Int): String = {
    val fulls = Math.floor(size / keyword.length).toInt
    val partials = size % keyword.length
      (keyword * fulls) + keyword.substring(0, partials)
  }

  def encode(keyword: String, message: String): String = {
    val paddedKey = padding(keyword, message.length)
    paddedKey.zip(message).map(z => z match {
      case (k, m) => offset(k, m)
    }).mkString
  }

  def decode(keyword: String, message: String): String = {
    ??? //keyword
  }

  def decipher(cipher: String, message: String): String = {
    ??? //cipher
  }

}
