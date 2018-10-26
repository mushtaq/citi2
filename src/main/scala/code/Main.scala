package code

import code.StringExt.RichString
import data.Book
import data.Data.books

object Main extends App {

  println(Sorter.sort(List(19, 40, 7, 10, 23)))
  println(Sorter.sort(List("s", "d", "a", "z")))

  {
    implicit val intOrd111111: Ord[Int] = (a: Int, b: Int) => a > b
    println(Sorter.sort(List(Option(10), Option.empty[Int], Option(3))))
  }

  println(Sorter.sort(List(Option("z"), Option.empty[String], Option("a"))))
  println(Sorter.sort(List(Option(("z", 9)), Option.empty[(String, Int)], Option(("z", 4)))))
  println(Sorter.sort(List(Option(("z", books(0))), Option.empty[(String, Book)], Option(("z", books(3))))))

  println("mushtaq".hello)
}
