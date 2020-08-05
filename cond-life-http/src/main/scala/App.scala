import akka.actor.ActorSystem
import akka.http.scaladsl.Http
import akka.stream.ActorMaterializer
import com.condlife.http.expenses.Api

object App {

  def main(args: Array[String]) {

    implicit val system = ActorSystem("CondLife-system")
    implicit val mat = ActorMaterializer()
    implicit val ec = system.dispatcher

    val bindingFuture = Http().bindAndHandle(Api.route, "0.0.0.0")

    bindingFuture.failed.foreach { ex =>
      //log.error(ex, "Failed to bind to {}:{}!", host, port)
    }

  }
}
