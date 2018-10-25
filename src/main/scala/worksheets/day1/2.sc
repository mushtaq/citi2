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

val isEven: Int => Boolean = (x: Int) => x % 2 == 0
val isEven2: Int => Boolean = x => x % 2 == 0

filter(xs)(isEven)
filter(xs)(x => x % 2 == 0)
xs.filter(x => x % 2 == 0)

