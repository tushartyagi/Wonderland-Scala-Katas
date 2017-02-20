import scala.util.Random

case class Card(suit: String, rank: String)

case class Deck(cards: List[Card])

case class Player(name: String, deck: Deck)

object CardGameWar {
  // Feel free to use these cards or use your own data structure
  val suits = List("Spade", "Club", "Diamond", "Heart")
  val ranks = List("2", "3", "4", "5", "6", "7", "8", "9", "10", "Jack", "Queen", "King", "Ace")

  // Creates two shuffled decks of cards
  def createDecks: (Deck, Deck) = {
    val allCards =
      new Random shuffle (for {
        suit <- suits
        rank <- ranks
      } yield Card(suit, rank.toString))

    val List(d1, d2) = allCards.grouped(allCards.length / 2).toList
    (Deck(d1), Deck(d2))
  }

  def playRound(card1: Card, card2: Card): Card = (card1, card2) match {
    case (Card(s1, r1), Card(s2, r2)) =>
      if (ranks.indexOf(r1) > ranks.indexOf(r2)) card1
      else if (ranks.indexOf(r1) < ranks.indexOf(r2)) card2
      else if (suits.indexOf(s1) > suits.indexOf(s2)) card1
      else card2
  }

  def playGame(player1: Player, player2: Player): String = {
    ??? // Winner of Game
  }

}

