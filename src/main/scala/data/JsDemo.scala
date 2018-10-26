package data

import play.api.libs.json._

object JsDemo {
  def transform(json: JsValue): JsValue = json match {
    case JsNull             => json
    case boolean: JsBoolean => json
    case JsNumber(value)    => JsNumber(value * value)
    case JsString(value)    => json
    case JsArray(values)    => JsArray(values.map(x => transform(x)))
    case JsObject(values)   => JsObject(values.mapValues(x => transform(x)))
  }

  def dd() = 10
}
