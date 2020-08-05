package com.condlife.http.expenses

import java.time.LocalDate
import spray.json.DefaultJsonProtocol._

final case class Expense(
    date: LocalDate,
    merchant: String,
    amount: Double,
    description: String
)

object Expense {
  import com.condlife.http.util.Serializers.localDateFormat
  implicit val format = jsonFormat4(Expense.apply)
}
