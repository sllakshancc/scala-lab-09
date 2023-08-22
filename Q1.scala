class Rational(n: Int, d: Int) {
  require(d != 0, "Denominator cannot be zero")

  val numer: Int = n
  val denom: Int = d

  def neg: Rational = new Rational(-numer, denom)

  def getRational: String = s"$numer/$denom"
}


@main def main() = {
    val a = Rational(20, 3)
    println(a.getRational)
    val negA = a.neg
    println(negA.getRational)
}