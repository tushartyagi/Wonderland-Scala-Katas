import AlphabetCipher._
import org.scalatest._

class AlphabetCipherSpec extends FlatSpec with Matchers {
  "offset" should "find the correct character by using row and column" in {
    assert(offset('b', 'a') == 'b')
    assert(offset('b', 'b') == 'c')
    assert(offset('b', 'c') == 'd')
  }

  "padding" should "increase the length of the string to the size provided" in {
    assert(padding("test", 4) == "test")
    assert(padding("test", 8) == "testtest")
    assert(padding("test", 10) == "testtestte")
  }

  "encode" should "encode given a secret keyword" in {
    assert(encode("vigilance","meetmeontuesdayeveningatseven") == "hmkbxebpxpmyllyrxiiqtoltfgzzv")
    assert(encode("scones","meetmebythetree") == "egsgqwtahuiljgs")
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
