import scala.collection.mutable

val xs = List(1, 2, 3, 4, 5)

10 :: xs

xs

xs.map(x => x * x)

xs.filter(x => x % 2 == 0)


def square(x: Int): Int = x * x

square(19)


val squareOp: Int => Int = x => x * x

def map[A, B](xs: List[A], op: A => B): List[B] = {
  val iterator = xs.iterator
  val result: mutable.Buffer[B] = mutable.Buffer.empty

  while (iterator.hasNext) {
    result += op(iterator.next())
  }

  result.toList
}

def map2[A, B](xs: List[A], op: A => B): List[B] = {
  val iterator = xs.iterator
  var result: List[B] = List.empty

  while (iterator.hasNext) {
    result = op(iterator.next()) :: result
  }

  result.reverse
}

def map3[A, B](xs: List[A], op: A => B): List[B] = {
  if(xs.isEmpty) List.empty else  op(xs.head) :: map3(xs.tail, op)
}

def map4[A, B](xs: List[A], op: A => B): List[B] = {
  def loop(rem: List[A], res: List[B]): List[B] = {
    if(rem.isEmpty) res else loop(rem.tail, op(rem.head) :: res)
  }

  loop(xs, Nil).reverse
}


map4((1 to 10000).toList, squareOp)

