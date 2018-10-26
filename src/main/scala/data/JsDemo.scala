package data

import play.api.libs.json._

object JsDemo {
  def transform(json: JsValue): JsValue = json match {
    case JsNull                  => json
    case boolean: JsBoolean      => json
    case JsNumber(value)         => JsNumber(value * value)
    case JsString("urn" :: post) => JsString(s"hello $post")
    case JsArray(values)         => JsArray(values.map(x => transform(x)))
    case JsObject(values)        => JsObject(values.mapValues(x => transform(x)))
    case _                       => json
  }

  object :: {
    def unapply(arg: String): Option[(String, String)] = arg.split(":") match {
      case Array(pre, post) => Some((pre, post))
      case _                => None
    }
  }

}
