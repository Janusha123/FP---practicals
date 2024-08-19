import scala.collection.mutable.Map
import scala.io.StdIn.readLine
import scala.io.StdIn.readInt
object Demo {
  def main(args: Array[String]): Unit = {
    //Question 1
    // println("Enter the amount: ")
    // val amount = readInt()
    // println(s"The total interest is: ${totalInterest(amount)}")
  
    //Question 2
    // println("Enter the number: ")
    // val number = readInt()
    // checkNumber(number)

    //Question 3
    val names = List("Benny", "Niroshan", "Saman", "Kumara")

    println(formatNames("Benny", toUpper))
    println(formatNames("Niroshan", name => name.substring(0, 2).toUpperCase + name.substring(2)))
    println(formatNames("Saman", toLower))
    println(formatNames("Kumara", name => name.substring(0, 1).toUpperCase + name.substring(1, name.length - 1).toLowerCase + name.substring(name.length - 1).toUpperCase))
  }
  
  //Question 1
  val interest = (amount:Int, rate: Double) => amount * rate / 100;

  def totalInterest(amount: Int): Double = {
    var total: Double = 0.0;
    if(amount > 2000000){
      total = interest(amount, 6.5).toInt
    } else if (amount > 200000){
      total = interest(amount, 3.5).toInt
    } else if (amount > 20000){
      total = interest(amount, 4.0).toInt
    } else {
      total = interest(amount, 2.0).toInt
    }
    return total;
  }

  //Question 2
  val isEven: Int => Boolean = (num: Int) => num % 2 == 0
  val isOdd: Int => Boolean = (num: Int) => num % 2 != 0

  def checkNumber(input: Int): Unit ={
    input match {
      case x if x <= 0 => println("Negative/Zero is input")
      case x if isEven(x) => println("Even number is given")
      case x if isOdd(x) => println("Odd number is given")
    }
  }
  
  //Question 3
  def toUpper(name: String): String = name.toUpperCase
  def toLower(name: String): String = name.toLowerCase
  def formatNames(name: String, formatFunc: String => String): String = formatFunc(name)

}
