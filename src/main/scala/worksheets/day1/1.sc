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

def loop[A, B](xs: List[A], seed: B)(f: (B, A) => B): B = {
  if(xs.isEmpty) seed else loop(xs.tail, f(seed, xs.head))(f)
}

def map4[A, B](xs: List[A])(op: A => B): List[B] = {
  loop(xs, List.empty[B])((acc, elm) => op(elm) :: acc).reverse
}

def filter2[T](xs: List[T])(op: T => Boolean): List[T] = {
  loop(xs, List.empty[T])((acc, elm) => if(op(elm)) elm :: acc else acc).reverse
}

def reverse[A](xs: List[A]): List[A] = {
  loop(xs, List.empty[A])((acc, elm) => elm :: acc)
}

def stringify[A](xs: List[A]): String = {
  loop(xs, "")((acc, elm) => acc + elm.toString)
}

map4((1 to 10000).toList)(x => x * x)
filter2(xs)(x => x % 2 == 0)
reverse((1 to 10000).toList)
stringify((1 to 10000).toList)

