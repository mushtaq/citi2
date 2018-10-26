
def length[T](xs: List[T]): Int = xs match {
  case Nil              =>  0
  case ::(head, tail)   => 1 + length(tail)
}
