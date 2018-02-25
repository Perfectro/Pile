object Main {
  def main(args: Array[String]): Unit = {
    val pile = Pile(List(0, 1, 2, 1, 0))
    pile.print
    println(pile.isPalindrome)
    println(pile.canBePalindrome)

    val p1 = pile
      .push(1)
      .push(1)
      .push(1)
      .push(1)
    p1.print
    println(p1.isPalindrome)
    println(p1.canBePalindrome)

    val p2 = pile.shake()
    println(p2.isPalindrome)
    println(p2.canBePalindrome)
  }
}
