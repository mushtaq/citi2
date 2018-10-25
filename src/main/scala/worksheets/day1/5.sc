
""


sealed trait Day

object Day {
  case object Monday extends Day
  case object Tuesday extends Day
}


Day.Monday
Day.Tuesday

Set(1, 2, 3): Set[Int]

val map = Map(1 -> "a", 2 -> "b"): Map[Int, String]

map(1)
map(10)


