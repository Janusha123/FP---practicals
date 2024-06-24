object demo {
  def main(args: Array[String]): Unit = {
    //Question 1
    var k, i, j = 2;
    var m, n = 5;
    var f = 12.0f;
    var g = 4.0f;
    // var c = 'X';

    println(s"k + 12*m = ${k + 12*m}");
    println(s"m / j = ${m/j}");
    println(s"n % j = ${n % j}");
    println(s"m/j*j = ${m / j*j}");
    println(s"f + 10*5 + g = ${f + 10*5 + g}");
    i+=1;
    println(s"++i*n = ${i*n}");

    //Question 2

    var a: Int = 2;
    var b: Int = 3;
    var c: Int = 4;
    var d: Int = 5;

    // var k: Float = 4.3f;

    // println(--b *a + c*d--);
    b-=1;
    val result = b * a + c * d;
    d -= 1;
    println(s"\n${result}");

    //println(a++)
    println(a);
    a += 1;

    println(-2 * (g - k) + c);

    //println(c = c++)
    c += 1
    println(c)

    //println(c = ++c * a++)
    c += 1 // equivalent to ++c
    val temp = c * a
    a += 1 // equivalent to a++
    c = temp
    println(c)



    println(s"\nTotal salary of employee: ${totalAmount(40, 30)}");
    println("\nTotal profits for different ticket prices: ")
    print(profit(20), profit(30), profit(10), profit(25));
  }

  //Question 3

  def normalHours(x: Int): Int = {
    return 250 * x;
  }

  def otHours(x: Int): Int = {
    return 85 * x;
  }

  def tax(x: Int, y: Int): Double = {
    return (x+y)*0.12;
  }

  def totalAmount(nh: Int, ot: Int): Double = {
    var totalAmount = normalHours(nh) + otHours(ot) + tax(nh, ot);
    return totalAmount;
  }

  //Question 4

  def attendees(x: Int): Int = {
    return 120 + ((15 - x)/5)*20;
  }

  def revenue(x: Int): Double = {
    return attendees(x)*x;
  }

  def cost(x: Int): Double = {
    return 500 + (attendees(x)*3);
  }

  def profit(x: Int): Double = {
    return revenue(x) - cost(x);
  }
}