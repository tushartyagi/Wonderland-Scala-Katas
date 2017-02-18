object AlphabetCipher {

  /** Looks for the combination of row and col in the substitution chart.
      Pick the col, and find the letter in the corresponding row in that col*/
  def offsetEncoding(col: Char, row: Char): Char = {
    val shiftedRow = row.toInt - 'a'.toInt
    val shiftedCol = col.toInt - 'a'.toInt
    (((shiftedCol + shiftedRow) % 26) + 'a'.toInt).toChar
  }

  /** Start in the particular row and move right until the offset character 
      is found, the difference is the offset from `a' */
  def offsetDecoding(row: Char, offset: Char): Char = {
    if (offset >= row) // Just move forward
    ('a' + (offset - row)).toChar
    else { // Move forward, break at 'z' and then start from 'a'
      ('a' + ('z' - row + offset - 'a' + 1)).toChar
    }
  }

  /** Technically this is the exact complement/opposite? of `offsetDecoding` 
    but instead of moving right in the rows, we have to move down in the 
    columns. */
  def offsetDecipher(col: Char, offset: Char): Char = {
    offsetDecoding(col, offset)
  }

  /** Attaches the string to itself until it has the proper size */
  def pad(keyword: String, size: Int): String = {
    val fulls = Math.floor(size / keyword.length).toInt
    val partials = size % keyword.length
      (keyword * fulls) + keyword.substring(0, partials)
  }

  def encode(keyword: String, message: String): String = {
    val paddedKey = pad(keyword, message.length)
    paddedKey.zip(message).map(z => z match {
      case (k, m) => offsetEncoding(k, m)
    }).mkString
  }

  def decode(keyword: String, message: String): String = {
    val paddedKey = pad(keyword, message.length)
    paddedKey.zip(message).map(z => z match {
      case (k, m) => offsetDecoding(k, m)
    }).mkString
  }

  def unpad(s: String): String = {
    /** Split the string around the first letter of the string, then search for
      the repetition of first string. All strings before the repetition if 
      concatenated will give the unpadded string. */
    val strings = s.split("(?=" + s(0) + ")")
    unpadHelper(strings.head, strings.head, strings.tail)
  }

  def unpadHelper(root: String, current: String, ss: Seq[String]): String = {
    if (root == ss.head) current
    else unpadHelper(root, current + ss.head, ss.tail)
  }

  def decipher(cipher: String, message: String): String = {
    val paddedKey = cipher.zip(message).map(z => z match {
      case (c, m) => offsetDecipher(m, c)
    }).mkString
    unpad(paddedKey)
  }

}
