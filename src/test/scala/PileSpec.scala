import org.scalatest.Matchers
import org.scalatest.WordSpec

class PileSpec extends WordSpec with Matchers {

  "A pile" when {
    "empty" should {
      val pile = Pile(List.empty)

      "be a palindrome" in {
        pile.isPalindrome shouldEqual true
        pile.canBePalindrome shouldEqual true
      }

      "not pop any element" in {
        pile.pop() shouldEqual pile
      }

      "push any element" in {
        pile.push(0) shouldEqual Pile(List(0))
      }

      "be reversible" in {
        pile.reverse shouldEqual pile
      }

      "be shakable" in {
        pile.shake() shouldEqual pile
      }
    }

    "valid" should {
      val pile = Pile(List(0, 1, 2, 1, 0))

      "be a palindrome" in {
        pile.isPalindrome shouldEqual true
        pile.canBePalindrome shouldEqual true
      }

      "not pop any element" in {
        pile.pop() shouldEqual Pile(List(1, 2, 1, 0))
      }

      "push any element" in {
        pile.push(0) shouldEqual Pile(List(0, 1, 2, 1, 0, 0))
      }

      "be reversible" in {
        pile.reverse shouldEqual pile
      }

      "be shakable and still a palindrome" in {
        val p1 = pile.shake()

        p1.shake() should not equal pile
        p1.canBePalindrome shouldEqual true
      }
    }

    "invalid" should {
      val pile = Pile(List(0, 1, 2, 1))

      "be a palindrome" in {
        pile.isPalindrome shouldEqual false
        pile.canBePalindrome shouldEqual false
      }

      "be transformable to a palindrome" in {
        val p1 = pile.pop()

        p1.isPalindrome shouldEqual true
        p1.canBePalindrome shouldEqual true
      }

      "not pop any element" in {
        pile.pop() shouldEqual Pile(List(1, 2, 1))
      }

      "push any element" in {
        pile.push(0) shouldEqual Pile(List(0, 1, 2, 1, 0))
      }

      "be reversible" in {
        pile.reverse shouldEqual Pile(List(1, 2, 1, 0))
      }

      "be shakable and still not a palindrome" in {
        val p1 = pile.shake()

        p1.shake() should not equal pile
        p1.isPalindrome shouldEqual false
        p1.canBePalindrome shouldEqual false
      }
    }
  }
}
