class Account(initialBalance: Double = 0.0) {
  private var balance: Double = initialBalance

  def deposit(amount: Double): Unit = {
    if (amount > 0) {
      balance += amount
      println(s"Deposited $amount. New balance: $balance")
    } else {
      println("Invalid deposit amount.")
    }
  }

  def withdraw(amount: Double): Unit = {
    if (amount > 0 && amount <= balance) {
      balance -= amount
      println(s"Withdrew $amount. New balance: $balance")
    } else {
      println("Invalid withdrawal amount or insufficient balance.")
    }
  }

  def transfer(amount: Double, beneficiary: Account): Unit = {
    if (amount > 0 && amount <= balance) {
      balance -= amount
      beneficiary.deposit(amount)
      println(s"Tranfered $amount. New balance: $balance")
    } else {
      println("Invalid transfer amount or insufficient balance.")
    }
  }

  def getBalance: Double = balance
}

@main def main() = {

    val Account1 = new Account(1000.0)
    val Account2 = new Account(500.0) 

    println(s"Account 1 balance: ${Account1.getBalance}")
    println(s"Account 2 balance: ${Account2.getBalance}")   

    Account1.deposit(200.0)
    Account1.withdraw(300.0)    
    Account1.transfer(150.0, Account2)  

    println(s"Account 1 balance: ${Account1.getBalance}")
    println(s"Account 2 balance: ${Account2.getBalance}")

}