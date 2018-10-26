package code

object StringExt {
  implicit class RichString(val string: String) {
    def hello = s"hello $string"
  }
}
