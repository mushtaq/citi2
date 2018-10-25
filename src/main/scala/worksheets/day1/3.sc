
val xs = List(2, 3, 4, 6, 1, 5, 8)

xs.map(x => x * x)
xs.filter(x => x % 2 == 0)
xs.reverse

xs.foldLeft(List.empty[Int])((acc, elm) => elm :: acc)
