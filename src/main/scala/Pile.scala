case class Pile(var numbers: scala.collection.mutable.Queue[Int]) {
  def push(element: Int): Unit = {
    numbers.enqueue(element)
  }

  def pop(): Int = {
    numbers.dequeue()
  }

  def print: Unit = {
    println(numbers.mkString(", "))
  }

  def reverse(): Unit = {
    numbers = numbers.reverse
  }

  def shake(): Unit = {
    numbers = util.Random.shuffle(numbers)
  }

  def isPalindrome: Boolean = {
    numbers == numbers.reverse
  }

  // Not Working :(
  def canBePalindrome: Boolean = {
    if (isPalindrome || numbers.isEmpty) {
      true
    } else {
      val palindromePotential = numbers.foldLeft[List[(Int, Int)]](List.empty) { (accumulator, element) =>
        accumulator.find(number => number._1 == element) match {
          case Some(number) =>
            (element, number._2 + 1) :: accumulator.filter(_ == number)
          case None =>
            (element, 1) :: accumulator
        }
      }.filter(element => element._2 % 2 != 0)
      println(palindromePotential)
      !(palindromePotential.size > 1)
    }
  }
}
