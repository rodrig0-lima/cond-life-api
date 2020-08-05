package com.condlife.http.util

import java.time.LocalDate
import java.time.format.DateTimeFormatter

import spray.json.{JsString, JsValue, JsonFormat, deserializationError}

import scala.util.Try

object Serializers {

  implicit val localDateFormat = new JsonFormat[LocalDate] {

    private val formatter = DateTimeFormatter.ISO_LOCAL_DATE
    private val deserializationErrorMessage =
      s"Expected date time in ISO offset date time format ex. ${LocalDate.now().format(formatter)}"
    override def write(obj: LocalDate): JsValue = JsString(formatter.format(obj))

    override def read(json: JsValue): LocalDate = {
      json match {
        case JsString(lDString) =>
          Try(LocalDate.parse(lDString, formatter)).getOrElse(deserializationError(deserializationErrorMessage))
        case _ => deserializationError(deserializationErrorMessage)
      }
    }
  }

}
