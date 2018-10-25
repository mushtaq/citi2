import scala.collection.mutable

val xs = List(1, 2, 3, 4, 5)

10 :: xs

xs

xs.map(x => x * x)

xs.filter(x => x % 2 == 0)


def square(x: Int): Int = x * x

square(19)


trait Op[A, B] {
  def invoke(x: A): B
}

val squareOp: Op1[Int, Int] = new Op1[Int, Int] {
  override def invoke(x: Int): Int = x * x
}

def map[A, B](xs: List[A], op: Op1[A, B]): List[B] = {
  val iterator = xs.iterator
  val result: mutable.Buffer[B] = mutable.Buffer.empty

  while (iterator.hasNext) {
    result += op.invoke(iterator.next())
  }

  result.toList
}

def map2[A, B](xs: List[A], op: Op1[A, B]): List[B] = {
  val iterator = xs.iterator
  var result: List[B] = List.empty

  while (iterator.hasNext) {
    result = op.invoke(iterator.next()) :: result
  }

  result.reverse
}


map2(xs, squareOp)

