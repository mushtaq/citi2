package code

trait Ord[T] {
  def lt(a: T, b: T): Boolean
}

object Ord {
  implicit val intOrd: Ord[Int]    = (a: Int, b: Int) => a < b
  implicit val strOrd: Ord[String] = (a: String, b: String) => a < b

  implicit def optOrd[T: Ord]: Ord[Option[T]] =
    (a: Option[T], b: Option[T]) =>
      (a, b) match {
        case (Some(x), Some(y)) => x < y
        case (_, None)          => false
        case (None, _)          => true
    }

  implicit def pairOrd[T1: Ord, T2: Ord]: Ord[(T1, T2)] =
    (a: (T1, T2), b: (T1, T2)) => {
      if (a._1 < b._1) true
      else if (b._1 < a._1) false
      else a._2 < b._2
    }

  implicit class RichT[T](val a: T) {
    def <(b: T)(implicit ord: Ord[T]): Boolean = ord.lt(a, b)
  }
}
