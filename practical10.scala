import scala.collection.mutable.Map
import scala.io.StdIn.readLine
import scala.io.StdIn.readInt

object Demo {
  def main(args: Array[String]): Unit = {

    // Question 1
    // val x = new Rational(3, 4)
    // val y = x.neg

    // println(s"Rational Number: $x")
    // println(s"Negation of rational number: $y")

    // Question 2
    // val x = new Rational(3, 4)
    // val y = new Rational(5, 8)
    // val z = new Rational(2, 7)

    // val result = x.sub(y.sub(z))

    // println(s"Rational Number x: $x")
    // println(s"Rational Number y: $y")
    // println(s"Rational Number z: $z")
    // println(s"Result of x - (y - z): $result")

    // Question 3 and Question 4
    val account1 = new Account("A1", 1000.0)
    val account2 = new Account("A2", -500.0)
    val account3 = new Account("A3", 200.0)
    val account4 = new Account("A4", -100.0)

    val bank = new Bank(List(account1, account2, account3, account4))

    account1.transfer(200.0, account3)
    println(s"After transfer: $account1, $account3")

    println("Accounts with negative balances:")
    bank.accountsWithNegativeBalances.foreach(println)

    println(s"Total balance: ${bank.totalBalance}")

    bank.applyInterest()
    println("Final balances after applying interest:")
    bank.accounts.foreach(println)
  }

  // Question 1
  class Rational(n: Int, d: Int) {
    require(d != 0, "Denominator cannot be zero")

    private val g = gcd(n.abs, d.abs)
    val numerator: Int = n / g
    val denominator: Int = d / g

    def this(n: Int) = this(n, 1)

    def neg: Rational = new Rational(-numerator, denominator)

    // Question 2
    def sub(that: Rational): Rational = {
      new Rational(
        numerator * that.denominator - that.numerator * denominator,
        denominator * that.denominator
      )
    }

    override def toString: String = s"$numerator/$denominator"

    private def gcd(a: Int, b: Int): Int = if (b == 0) a else gcd(b, a % b)
  }

  // Question 3
  class Account(val id: String, var balance: Double) {
    def deposit(amount: Double): Unit = {
      if (amount > 0) balance += amount
    }

    def withdraw(amount: Double): Unit = {
      if (amount > 0 && amount <= balance) balance -= amount
    }

    def transfer(amount: Double, toAccount: Account): Unit = {
      if (amount > 0 && amount <= balance) {
        this.withdraw(amount)
        toAccount.deposit(amount)
      }
    }

    override def toString: String = s"Account($id, $balance)"
  }

  // Question 4
  class Bank(val accounts: List[Account]) {
    def accountsWithNegativeBalances: List[Account] = {
      accounts.filter(_.balance < 0)
    }

    def totalBalance: Double = {
      accounts.map(_.balance).sum
    }

    def applyInterest(): Unit = {
      accounts.foreach { account =>
        if (account.balance > 0) {
          account.deposit(account.balance * 0.05)
        } else {
          account.withdraw(account.balance * 0.1)
        }
      }
    }
  }
}
