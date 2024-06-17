object Demo {
  def main(args: Array[String]): Unit = {
    println(s"Area of the disk: ${area(4)}")
    println(s"Temperature in Fahrenheit: ${fah(35)}")
    println(s"Volume of sphere: ${volume(5)}")
    println(s"Total cost of 60 books: ${totalcost(60)}")

    val totalrunning = easy(2) + tempo(3) + easy(2)
    println("Total running time: " + totalrunning)
  }
  //Question 1
  def area(x: Double): Double = {
    math.Pi * x * x
  }
  //Question 2
  def fah(c: Int): Double = {
    (1.8*c) + 32
  }
  //Question 3
  def volume(r: Int): Double = {
    (4/3)*math.Pi*r*r*r
  }
  //Question 4
  def dicount(x: Double) = {
    x*24.95*0.6
  }

  def shippingcost(b: Int): Double = {
    if(b < 50){
      return b*3
    } else {
      return (50*3) + (b-50)*0.75
    }
  }

  def totalcost(x: Int): Double={
    return shippingcost(x) + dicount(x)
  }
  //Question 5
  def easy(x:Int): Int = {
    return x*8
  }

  def tempo(x:Int): Int = {
    return x*7
  }

}
