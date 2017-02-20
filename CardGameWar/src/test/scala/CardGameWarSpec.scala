import CardGameWar._
import org.scalatest._

class CardGameWarSpec extends WordSpec with Matchers {
  // Creates a deck of cards

  "playRound" when {
    "the highest rank wins the cards in the round" in {
      assert(playRound( Card("Spade", "2"), Card("Spade","Ace")) == Card("Spade", "Ace"))
      assert(playRound( Card("Spade", "2"), Card("Club","3")) == Card("Club", "3"))
    }
    "queens are higher rank than jacks" in {
      assert(playRound( Card("Spade", "Queen"), Card("Spade","Jack")) == Card("Spade", "Queen"))
    }
    "kings are higher rank than queens" in {
      assert(playRound( Card("Spade", "Queen"), Card("Spade","King")) == Card("Spade", "King"))
    }
    "aces are higher rank than kings" in {
      assert(playRound( Card("Spade", "Ace"), Card("Spade","King")) == Card("Spade", "Ace"))
    }
    "if the ranks are equal, clubs beat spades" in {
      assert(playRound( Card("Club", "Ace"), Card("Spade","Ace")) == Card("Club", "Ace"))
    }
    "if the ranks are equal, diamonds beat clubs" in {
      assert(playRound( Card("Club", "Ace"), Card("Diamond","Ace")) == Card("Diamond", "Ace"))
    }
    "if the ranks are equal, hearts beat diamonds" in {
      assert(playRound( Card("Heart", "Ace"), Card("Diamond","Ace")) == Card("Heart", "Ace"))
    }
  }
  "playGame" when {
    "the player loses when they run out of cards" in {
      assert(playGame(Player("Bob", Deck(Nil)), Player("Alice", createDecks._1)) == "Alice")
      assert(playGame(Player("Bob", createDecks._1), Player("Alice", Deck(Nil))) == "Bob")
    }

    "the player with higher rank wins" in {
      val bob = Player("Bob", Deck(List(Card("Spade", "2"))))
      val alice = Player("Alice", Deck(List(Card("Club", "3"))))
      assert(playGame(bob, alice) == "Alice")
      assert(playGame(alice, bob) == "Alice")
    }

    "if both players have same rank, the player with higher suit wins" in {
      // Club > Spade
      val bob = Player("Bob", Deck(List(Card("Spade", "2"))))
      val alice = Player("Alice", Deck(List(Card("Club", "2"))))
      assert(playGame(bob, alice) == "Alice")
      assert(playGame(alice, bob) == "Alice")
      
    }

  }
}
