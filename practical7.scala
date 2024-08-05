import scala.collection.mutable.Map
import scala.io.StdIn.readLine
import scala.io.StdIn.readInt

object Demo {
  def main(args: Array[String]): Unit = {
    println(filterEvenNumbers(filterNumbers))
    println(calculateSquare(mapNumbers))
    println(filterPrime(inputPrime))
  }

  val filterNumbers = List(1, 2, 3, 4, 5, 6, 7, 8, 9, 10)
  def filterEvenNumbers(numbers: List[Int]): List[Int] = {
    numbers.filter(x => x % 2 == 0)
  }

  val mapNumbers = List(1, 2, 3, 4, 5)
  def calculateSquare(numbers: List[Int]): List[Int] = {
    numbers.map(x => x*x)
  }

  val inputPrime = List(1, 2, 3, 4, 5, 6, 7, 8, 9, 10)
  def filterPrime(numbers: List[Int]): List[Int] = {
    numbers.filter(x => x>1 && (2 until x).forall(y => x % y != 0))
  }
}
