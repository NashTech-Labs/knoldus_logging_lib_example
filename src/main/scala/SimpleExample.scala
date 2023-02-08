import com.knoldus.lib.RollbarProvider

import play.api.libs.json._

object SimpleExample extends App {

  case class Company(
    name: String,
    location: String,
    occupation: String
  )

  case class Employee(
    name: String,
    employeeNumber: String,
    position: String,
    department: String
  )

  implicit val CompanyWrites = Json.writes[Company]
  implicit val EmployeeWrites = Json.writes[Employee]

  val rollbarLogger = RollbarProvider.logger("a8d39c45f43f481398ab1b15f68a2eaf")
    .withKeyValue("company", Company("Knoldus inc.", "Canada, ON, Mississauga", "Software Development"))
    .withKeyValue("employee", Employee("Vlad Marinychev", "5062", "Software engineer", "Scala Studio"))
    .withFrequency(2)

  rollbarLogger.info("Joined the server!")
  rollbarLogger.warn("Suspicious activity")
  rollbarLogger.error("User doesn't have an access!")

}
