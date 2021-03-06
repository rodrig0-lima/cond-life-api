package com.condlife.http.expenses

import java.time.LocalDate

import akka.Done
import akka.http.scaladsl.server.Route
import akka.http.scaladsl.common.{EntityStreamingSupport, JsonEntityStreamingSupport}
import akka.http.scaladsl.server.Directives._
import akka.stream.scaladsl.Source
import akka.http.scaladsl.marshallers.sprayjson.SprayJsonSupport._
import com.condlife.http.util.CORSHandler

import scala.concurrent.Future

object Api extends CORSHandler {
  implicit val jsonStreamingSupport: JsonEntityStreamingSupport = EntityStreamingSupport.json()

  val route: Route = corsHandler {
    path("expenses") {
      get {
        complete(MockData.expenses)
      } ~
        post {
          entity(as[Expense]) { expense =>
            println(expense)
            complete(Future.successful(Done))
          }
        }
    }
  }
}

object MockData {

  val expenses = Source(List(
    Expense(LocalDate.now() ,"Home depot", 500.50, "Back splash "),
    Expense(LocalDate.now().minusWeeks(2),"Rona", 300.70, "Ornamental plants")
  ))
}
