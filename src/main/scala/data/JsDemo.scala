package data

import play.api.libs.json._

object JsDemo {
  def transform(json: JsValue): JsValue = json match {
    case JsNull                         => json
    case jsBoolean: JsBoolean           => json
    case JsNumber(value) if value > 100 => JsNumber(value * value)
    case JsString("urn" :: post)        => JsString(s"hello $post")
    case JsArray(values)                => JsArray(values.map(x => transform(x)))
    case JsObject(values) =>
      val stringToValue = values.map {
        case pair @ ("m" | "n", _) => pair
        case (k, v)                => (k, transform(v))
      }
      JsObject(stringToValue)
    case _ => json
  }

  null.isInstanceOf[Int]
  null.asInstanceOf[Int]

  object :: {
    def unapply(arg: String): Option[(String, String)] = arg.split(":") match {
      case Array(pre, post) => Some((pre, post))
      case _                => None
    }
  }

}
