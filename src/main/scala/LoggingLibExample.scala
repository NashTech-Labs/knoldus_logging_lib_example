import com.knoldus.lib.RollbarProvider

object LoggingLibExample extends App {

  case class Attribute(
    att: String,
    name: String
  )

  import play.api.libs.json._

  implicit val Attribute1Writes = Json.writes[Attribute]
  implicit val Attribute1Format = Json.format[Attribute]

  /** Creating a new rollbar logger object using token  */
  val rollbarLogger = RollbarProvider.logger("token")
    /** withSendToRollbar helps us to set the option not to send logs to rollbar. Logs will be only in console. Default value - true */
    .withSendToRollbar(true)
    /** here we can set percentage of logs which will be displayed in rollbar/console. Frequency 1 - 100%, 2 - 50%, 3 - 33% etc. Default value - 1 */
    .withFrequency(1)
    /** option to set organization */
    .organization("organization")
    /** option to set requestId */
    .requestId("requestId")
    /** option to set additional custom data to logs. Key should be string type. Value can be any data type */
    .withKeyValue("key", Attribute("att", "name"))
    /** same like above, but with list of values*/
    .withKeyValues("key", List(Attribute("att1", "name"), Attribute("att2", "name")))


  /** Below you can see examples how to send logs to rollbar/console with different message levels */
  rollbarLogger.info("info message!")
  rollbarLogger.error("error message!")
  rollbarLogger.warn("warning message!")
  rollbarLogger.debug("debug message!")
}

