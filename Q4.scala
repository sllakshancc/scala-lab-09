class Account(initialBalance: Double) {
  private var balance: Double = initialBalance

  def applyInterest(): Unit = {
    if (balance > 0) {
      balance += balance * 0.05
    } else {
      balance += balance * 0.1
    }
  }

  def getBalance: Double = balance
}


class Bank(accounts: List[Account]) {
  def getAllAccounts: List[Account] = accounts

  def getAccountsWithNegativeBalance: List[Account] = {
    accounts.filter(_.getBalance < 0)
  }

  def calculateTotalBalance: Double = {
    accounts.map(_.getBalance).sum
  }

  def applyInterestToAllAccounts(): Unit = {
    accounts.foreach(_.applyInterest())
  }
}

@main def main() = {

  val account1 = new Account(100.0)
  val account2 = new Account(-200.0)
  val account3 = new Account(500.0)

  val bank = new Bank(List(account1, account2, account3))

  println("Accounts with negative balances:")
  val accountsWithNegativeBalance = bank.getAccountsWithNegativeBalance
  accountsWithNegativeBalance.foreach(account => println(s"${account.getBalance}"))

  val totalBalance = bank.calculateTotalBalance
  println(s"Total balance of all accounts: $totalBalance")

  bank.applyInterestToAllAccounts()
  println("Balances after applying interest:")
  bank.getAllAccounts.foreach(account => println(s"${account.getBalance}"))

}