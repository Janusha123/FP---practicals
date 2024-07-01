import scala.io.StdIn.readLine

object demo {
  def main(args: Array[String]): Unit = {

    println("Enter a string to reverse:");
    val input = readLine();
    println(s"Reversed string: ${reverseString(input)}");

    val inputList = List("hello", "world", "Scala", "programming", "is", "awesome");
    val filteredList = filterLongStrings(inputList);
    println("List of filtered strings: ");
    println(filteredList);

    println(s"Mean of two numbers: ${mean(430, 52)}");

    val myList = List(1, 2, 3, 4, 5);
    println(s"Sum of even numbers: ${evenNumbers(myList)}");
    
  }

  //Question 1
  def reverseString(str: String): String = {
    if (str.length == 0) ""
    else reverseString(str.tail) + str.head
  }

  //Question 2
  def filterLongStrings(strings: List[String]): List[String] = {
    strings.filter(_.length > 5);
  }

  //Question 3
  def mean(x: Int, y: Int): Float = {
    var avg = (x + y).toFloat / 2;
    val roundedAvg = f"$avg%.2f".toFloat;
    return roundedAvg;
  }
  // Question 4
  def evenNumbers(numbers: List[Int]): Int = {
    var sum = 0;
    for (num <- numbers) {
      if(num % 2 == 0){
        sum = sum + num;
      }
    }

    return sum;
  }
  
}