import scala.io.StdIn.readLine, scala.io.StdIn.readInt

object demo {
  //Question 1
  def main(args: Array[String]): Unit = {
    var quantities = Array(10, 20, 30, 40);
    var names = Array("Books", "Pencils", "Pens", "Papers");  

    var check = true;

    while(check){
      println("Enter command(1: To check Inventory, 2: To add item, 3: To sell item, 4: To exit):");
      val command = scala.io.StdIn.readInt();

      if(command == 1){
          displayInventory(names, quantities);
      } else if(command == 2) {
          println("Insert Item: ");
          val item = scala.io.StdIn.readLine();
          println("Insert Amount: ");
          val amount = scala.io.StdIn.readInt();
          addItem(item, amount, names, quantities);
      } else if(command == 3) {
          println("Insert Item: ");
          val item = scala.io.StdIn.readLine();
          println("Insert Amount: ");
          val amount = scala.io.StdIn.readInt();
          sellItem(item, amount, names, quantities);
      } else if(command == 4){
          check = false;
      } else {
          println("Incorrect Command");
      }
    }

    //Question 2
    println("Enter integer: ");
    val i = scala.io.StdIn.readInt();
    patternMatch(i);

    //Question 3
    // Test inputs and outputs
    val namesList = List("Benny", "Niroshan", "Saman", "Kumara");

    // Formatting each name according to the specified output
    val formattedNames = namesList.map {
      case "Benny" => formatNames("Benny")(toUpper)
      case "Niroshan" =>
        val firstTwoUpper = "NI" + "roshan".toLowerCase
        formatNames(firstTwoUpper)(identity)
      case "Saman" => formatNames("Saman")(toLower)
      case "Kumara" =>
        val firstFiveLowerLastUpper = "Kumar".toLowerCase + "A".toUpperCase
        formatNames(firstFiveLowerLastUpper)(identity)
      case other => other // Default case to handle unexpected names
    }

    // Print the formatted names
    formattedNames.foreach(println)

  }
  
  //Question 1
  def displayInventory(names: Array[String], quantities: Array[Int]): Unit = {
    println("Current Inventory: ")
    for ((elem1, elem2) <- names.zip(quantities)) {
      println(s"$elem1 - $elem2")
    }
  }

  def addItem(item: String, amount: Int, names: Array[String], quantities: Array[Int]): Unit = {
    val itemIndex = names.indexOf(item);
    if(itemIndex == -1){
      printf("Item does not exist");
    } else {
      quantities(itemIndex) += amount;
    }
  }

  def sellItem(item: String, amount: Int, names: Array[String], quantities: Array[Int]): Unit = {
    val itemIndex = names.indexOf(item);
    if(itemIndex == -1){
      println("Item does not exist");
    } else if(quantities(itemIndex) < amount){
      println(s"Insufficient stock for ${item}");
    } else {
      quantities(itemIndex) -= amount;
    }
  }

  //Question 2
  def patternMatch(x: Int): Unit = {
    if(x <= 0){
      println("Negative/Zero");
    } else if(x % 2 == 0){
      println("Even Number");
    } else {
      println("Odd Number");
    }
  }

  //Question 3
  // Method to convert a string to uppercase
  def toUpper(name: String): String = {
    name.toUpperCase()
  }

  // Method to convert a string to lowercase
  def toLower(name: String): String = {
    name.toLowerCase()
  }

  // Method to format names using a provided function
  def formatNames(name: String)(formatFunction: String => String): String = {
    formatFunction(name)
  }
}

  