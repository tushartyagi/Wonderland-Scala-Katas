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

  def playRound(player1: Card, player2: Card): Card = (player1, player2) match {
    case (Card(suit1, rank1), Card(suit2, rank2)) =>
      if (ranks.indexOf(rank1) > ranks.indexOf(rank2)) player1
      else if (ranks.indexOf(rank1) < ranks.indexOf(rank2)) player2
      else if (suits.indexOf(suit1) > suits.indexOf(suit2)) player1
      else player2
  }

  def playGame(player1: Player, player2: Player): String = (player1, player2) match {
    case (Player(_, Deck(Nil)), _) => player2.name
    case (_, Player(_, Deck(Nil))) => player1.name
    case (Player(p1, deck1), Player(p2, deck2)) => (deck1, deck2) match {
      case (Deck(d1Head::d1Tail), Deck(d2Head::d2Tail)) =>
        playRound(d1Head, d2Head) match {
          case `d1Head` => playGame(Player(p1, Deck(d1Tail:+d1Head:+d2Head)),
            Player(p2, Deck(d2Tail)))
          case `d2Head` => playGame(Player(p1, Deck(d1Tail)),
            Player(p2, Deck(d2Tail:+d2Head:+d1Head)))
        }
    }
  }
}

