case class Pile(private val numbers: List[Int] = List.empty) {
  def push(element: Int): Pile = {
    Pile(numbers :+ element)
  }

  def pop(): Pile = {
    if (numbers.nonEmpty) {
      Pile(numbers.drop(1))
    } else {
      this
    }
  }

  def print: Unit = {
    println(numbers.mkString(", "))
  }

  def reverse(): Pile = {
    Pile(numbers.reverse)
  }

  def shake(): Pile = {
    Pile(util.Random.shuffle(numbers))
  }

  def isPalindrome: Boolean = {
    numbers == numbers.reverse
  }

  def canBePalindrome: Boolean = {
    numbers.foldLeft[List[(Int, Int)]](List.empty) { (accumulator, element) =>
      accumulator.find(number => number._1 == element) match {
        case Some(number) =>
          (element, number._2 + 1) :: accumulator.filterNot(i => i == number)
        case None =>
          (element, 1) :: accumulator
      }
    }.count(a => a._2 % 2 != 0) <= 1
  }
}
