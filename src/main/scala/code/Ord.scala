package code

trait Ord[T] {
  def lt(a: T, b: T): Boolean
}

object Ord {
  val intOrd: Ord[Int] = (a: Int, b: Int) => a < b
}
