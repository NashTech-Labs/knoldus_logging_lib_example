import com.knoldus.lib.RollbarProvider

object LoggingLibExample extends App {

  case class Attribute(
    att: String,
    name: String
  )

  import play.api.libs.json._

  implicit val Attribute1Writes = Json.writes[Attribute]
  implicit val Attribute1Format = Json.format[Attribute]


  val rollbarLogger = RollbarProvider.logger("a8d39c45f43f481398ab1b15f68a2eaf")
    .withSendToRollbar(true)
    .withFrequency(1)
    .organization("organization")
    .withKeyValue("key", Attribute("att", "name"))
    .withKeyValues("key", List(Attribute("att1", "name"), Attribute("att2", "name")))
    .requestId("requestId")

  rollbarLogger.info("info message!")
  rollbarLogger.error("error message!")
  rollbarLogger.warn("warning message!")
  rollbarLogger.debug("debug message!")
}

