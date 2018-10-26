package code

object Main extends App {

  println(Sorter.sort(List(19, 40, 7, 10, 23))(Ord.intOrd))
  println(Sorter.sort(List("s", "d", "a", "z"))(Ord.strOrd))
  println(Sorter.sort(List(Option(10), Option.empty[Int], Option(3)))(Ord.intOptOrd))
  println(Sorter.sort(List(Option("z"), Option.empty[String], Option("a")))(Ord.strOptOrd))
}
