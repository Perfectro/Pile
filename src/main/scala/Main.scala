object Main {
  def main(args: Array[String]): Unit = {
    val pile = Pile(scala.collection.mutable.Queue(0, 1, 2, 1, 0))
    println(pile.isPalindrome)
    pile.print
    pile.pop()
    pile.print
    println(pile.isPalindrome)
    pile.push(0)
    pile.print
    println(pile.isPalindrome)
    pile.reverse()
    pile.print
    pile.shake()
    pile.print
    println(pile.isPalindrome)
    println(pile.canBePalindrome)
  }
}
