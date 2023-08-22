class Rational(n: Int, d: Int) {
  require(d != 0, "Denominator cannot be zero")

  val numer: Int = n
  val denom: Int = d

  def sub(x: Rational): Rational = {
    new Rational(numer * x.denom - x.numer * denom, denom * x.denom)
  }

  def getRational: String = s"$numer/$denom"
}


@main def main() = {
    val x = Rational(3, 4)
    val y = Rational(5, 8)
    val z = Rational(2, 7)
    
    val result = (x.sub(y)).sub(z)
    println(result.getRational)
}