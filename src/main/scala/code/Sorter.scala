package code
import code.Ord.RichT

object Sorter {

  def insert[T: Ord](x: T, sortedList: List[T]): List[T] = sortedList match {
    case Nil                      => List(x)
    case head :: tail if x < head => x :: sortedList
    case head :: tail             => head :: insert(x, tail)
  }

  def sort[T: Ord](xs: List[T]): List[T] = xs match {
    case Nil          => Nil
    case head :: tail => insert(head, sort(tail))
  }

}
