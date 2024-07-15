import scala.io.StdIn.readLine, scala.io.StdIn.readInt
import scala.collection.mutable.Set

object demo {
  def main(args: Array[String]): Unit = {
  //Question 1
    val productList = getProductList()
    println("\nProduct List:")
    printProductList(productList)
    println(s"\nTotal number of products: ${getTotalProducts(productList)}")
    
  //Question 2
    val book1 = Book("Hello", "C.D.Johnson", "123")
    val book2 = Book("Black", "R.S.Mathew", "243")
    val book3 = Book("Harry", "J.K.Rowling", "432")

    var books = Set(book1, book2, book3);

    var check = true

    while(check){
      println("Enter command(1 to add book, 2 to remove book, 3 to search book, 4 to display library, 5 to display authors list,0 to exit): ")
      val choice = readInt()

      choice match {
        case 1 => addBook(books)
        case 2 => removeBook(books)
        case 3 => searchBook(books)
        case 4 => displayLibrary(books)
        case 5 => displayByAuthor(books)
        case 0 => check = false
        case _ => println("Invalid command")

      }
    
    }  
  //Question 3
    println("Enter number to get fibonacci sequnce: ")
    val n = readInt()
    fibonacciSeq(n)

  }

  //Question 1
  def getProductList(): List[String] = {
    import scala.io.StdIn.readLine
    var productList: List[String] = List()
    var continue = true

    while (continue) {
      val product = readLine("Enter product name (or type 'done' to finish): ")
      if (product.toLowerCase == "done") {
        continue = false
      } else {
        productList = productList :+ product
      }
    }

    productList
  }

  def printProductList(productList: List[String]): Unit = {
    productList.zipWithIndex.foreach { case (product, index) =>
      println(s"${index + 1}. $product")
    }
  }

  def getTotalProducts(productList: List[String]): Int = {
    productList.length
  }

  //Question 2
  case class Book(title: String, author: String, isbn: String)

  def addBook(bookSet: Set[Book]): Unit = {
    val title = readLine("Enter title: ")
    val author = readLine("Enter author: ")
    val isbn = readLine("Enter ISBN: ")

    val book = Book(title, author, isbn)

    bookSet += book
  }

  def removeBook(bookSet: Set[Book]): Unit = {
    val isbn = readLine("Enter ISBN value of book to be removed: ")

    val bookToRemove = bookSet.find(book => book.isbn == isbn)

    bookToRemove match {
      case Some(book) =>
        bookSet -= book
        println(s"Book with ISBN ${isbn} has been removed.")
      case None =>
        println(s"No book found with ISBN ${isbn}.")
    }
  }

  def displayLibrary(bookSet: Set[Book]): Unit = {
    bookSet.foreach(book =>
      println(s"Title: ${book.title}, Author: ${book.author}, ISBN: ${book.isbn}")  
    )
  }

  def searchBook(bookSet: Set[Book]): Unit = {
    val bookTitle = readLine("Enter title of book: ")

    val bookToSearch = bookSet.find(book => book.title == bookTitle)

    bookToSearch match {
      case Some(book) =>
        println(s"${bookTitle} was written by ${book.author}.")
      case None =>
        println(s"No book found with title - ${bookTitle}.")
    }
  }

  def displayByAuthor(bookSet: Set[Book]): Unit = {
    val bookAuthor = readLine("Enter author's name: ")

    bookSet.foreach(book =>
      if(book.author == bookAuthor){
        println(s"Title: ${book.title}")
      }  
    )
  }

  //Question 3
  def fibonacci(n:Int):Int= n match {
    case x if x==0 => 0
    case x if x==1 => 1
    case x => fibonacci(n-1)+fibonacci(n-2)
  }

  def fibonacciSeq(n:Int):Unit= {
    if (n > 0) fibonacciSeq(n-1)
    println(fibonacci(n))
  }

}

  