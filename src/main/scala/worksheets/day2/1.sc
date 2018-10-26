
sealed trait Json
case class JsonArray(xs: List[Json]) extends Json
case class JsonObj(xs: Map[String, Json]) extends Json
case class JsonStr(value: String) extends Json
case class JsonNum(value: Double) extends Json
sealed trait JsonBoolean extends Json
case object JsonTrue extends JsonBoolean
case object JsonFalse extends JsonBoolean
case object JsonNull extends Json

sealed trait Tree[T]
case class Branch[T](value: T, left: Tree[T], right: Tree[T])
case class Leaf[T](value: T)
case object Empty extends Tree[Nothing]

sealed trait List[+T]
final case class Cons[T](head: T, tail: List[T]) extends List[T]
final case object Nil extends List[Nothing]


def length[T](xs: List[T]): Int = {
  if(xs == Nil) 0  else 1 + length(xs.asInstanceOf[Cons[T]].tail)
}

def reverse[T](xs: List[T]): List[T] = {
  if(xs == Nil) Nil else Cons(xs.asInstanceOf[Cons[T]].head, reverse(xs.asInstanceOf[Cons[T]].tail))
}

/////////////////////

trait Shape {
  def area: Double
  def draw(): Unit
}

case class Circle() extends Shape {
  override def area: Double = ???
}

case class Triangle() extends Shape {
  override def area: Double = ???
  override def draw(): Unit = ???
}

