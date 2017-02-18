import AlphabetCipher._
import org.scalatest._

class AlphabetCipherSpec extends FlatSpec with Matchers {
  "offsetEncoding" should "find the correct character by using row and column" in {
    assert(offsetEncoding('s', 'm') == 'e')
    assert(offsetEncoding('c', 'e') == 'g')
    assert(offsetEncoding('o', 'e') == 's')
  }

  "offsetDecoding" should "find the correct character by column and offset character" in {
    assert(offsetDecoding('s', 'e') == 'm')
    assert(offsetDecoding('s', 't') == 'b')
    assert(offsetDecoding('e', 'i') == 'e')
  }

  "offsetDecipher" should "find the correct character by column and offset character" in {
    assert(offsetDecipher('m', 'e') == 's')
    assert(offsetDecipher('e', 'g') == 'c')
    assert(offsetDecipher('e', 's') == 'o')
  }

  "padding" should "increase the length of the string to the size provided" in {
    assert(pad("test", 4) == "test")
    assert(pad("test", 8) == "testtest")
    assert(pad("test", 10) == "testtestte")
  }

  "encode" should "encode given a secret keyword" in {
    assert(encode("vigilance","meetmeontuesdayeveningatseven") == "hmkbxebpxpmyllyrxiiqtoltfgzzv")
    assert(encode("scones","meetmebythetree") == "egsgqwtahuiljgs")
  }

  "unpad" should "return the single string which we padded before" in {
    assert(unpad("vigilancevigilancevigil") == "vigilance")
    assert(unpad("sconessconesscones") == "scones")
  }

  "decode" should "decode an cyrpted message given a secret keyword" in {
    assert(decode("vigilance","hmkbxebpxpmyllyrxiiqtoltfgzzv") == "meetmeontuesdayeveningatseven")
    assert(decode("scones","egsgqwtahuiljgs") == "meetmebythetree")

  }

  "decipher" should "extract the secret keyword given an encrypted message and the original message" in {
    assert(decipher("opkyfipmfmwcvqoklyhxywgeecpvhelzg", "thequickbrownfoxjumpsoveralazydog") == "vigilance")
    assert(decipher("hcqxqqtqljmlzhwiivgbsapaiwcenmyu", "packmyboxwithfivedozenliquorjugs") == "scones")
  }
}
