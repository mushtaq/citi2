

class Address(var street: String = "", var pin: Int = 0)

val a = new Address()
a.street = "asdasd"
a.pin = 100

case class Person(name: String = "", age: Int = 100) {
  val greeting = s"Hello $name"
  def isAdult: Boolean = age > 18
}

val p = new Person("abc", 33)
val p2 = new Person("abc", 33)

p.isAdult
p.greeting

p.equals(p2)
p == p2

p eq p2

p.hashCode()
p2.hashCode()

val p3 = p.copy(age = 99)

p3.name eq p.name

new Person()
  .copy(age = 100)
  .copy(name = "asdasd")
