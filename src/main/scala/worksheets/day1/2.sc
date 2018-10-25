import scala.collection.mutable

val xs = List(1, 2, 3, 4, 5)


def filter[T](xs: List[T])(op: T => Boolean): List[T] = {
  val iterator = xs.iterator
  val result: mutable.Buffer[T] = mutable.Buffer.empty

  while (iterator.hasNext) {
    val x = iterator.next()
    if (op(x)) {
      result += x
    }
  }

  result.toList
}

def filter2[T](xs: List[T])(op: T => Boolean): List[T] = {
  def loop(rem: List[T], res: List[T]): List[T] = {
    if(rem.isEmpty) res
    else loop(rem.tail, if(op(rem.head)) rem.head :: res else res)
  }

  loop(xs, Nil).reverse
}

val isEven: Int => Boolean = (x: Int) => x % 2 == 0
val isEven2: Int => Boolean = x => x % 2 == 0

filter(xs)(isEven)
filter2(xs)(x => x % 2 == 0)
xs.filter(x => x % 2 == 0)

