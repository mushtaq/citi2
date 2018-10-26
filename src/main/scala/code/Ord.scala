package code

trait Ord[T] {
  def lt(a: T, b: T): Boolean
}

object Ord {
  val intOrd: Ord[Int]    = (a: Int, b: Int) => a < b
  val strOrd: Ord[String] = (a: String, b: String) => a < b

  val intOptOrd: Ord[Option[Int]] = (a: Option[Int], b: Option[Int]) =>
    (a, b) match {
      case (Some(x), Some(y)) => x < y
      case (_, None)          => false
      case (None, _)          => true
  }

  val strOptOrd: Ord[Option[String]] = (a: Option[String], b: Option[String]) =>
    (a, b) match {
      case (Some(x), Some(y)) => x < y
      case (_, None)          => false
      case (None, _)          => true
  }
}
