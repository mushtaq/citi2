import data.Data._

books.foreach(println)

books.map(x => x.price)
books.map(book => book.price)
books.map(_.price)

books.filter(_.author == "odersky").foreach(println)

books.minBy(_.price)

books.sortBy(- _.price).foreach(println)

books.sortBy(book => (-book.price, book.title)).foreach(println)