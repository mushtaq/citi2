package data
import code.Ord

case class Address(street: String, pin: Int)

object Address {}

case class Person(name: String, address: Address)

object Person {}

case class Book(
    author: String,
    title: String,
    price: Double
)

object Book {
  implicit val bookOrd: Ord[Book] = (a: Book, b: Book) => a.price < b.price
}

object Data {

  val books = List(
    Book("odersky", "scala prog", 100),
    Book("odersky", "apple", 100),
    Book("odersky", "complexity", 400),
    Book("minsky", "ocaml prog", 1000),
    Book("minsky", "sml", 88),
    Book("hickey", "clojure prog", 500)
  )

  val people = List(
    Person("mushtaq", Address("baner", 123)),
    Person("ajit", Address("pashan", 100))
  )
}
