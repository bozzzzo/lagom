package impl

import akka.NotUsed
import com.lightbend.lagom.scaladsl.api.ServiceCall
import scala.concurrent.ExecutionContext
import api.{ BarService, FooService }

class BarServiceImpl(fooService: FooService)(implicit ec: ExecutionContext) extends BarService {
  override def bar = ServiceCall { _ =>
    fooService.foo.invoke().map { foo =>
      s"$foo bar"
    }
  }
}
