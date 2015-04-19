package main.scala

import java.math.MathContext

import scala.math.BigDecimal
import scala.math.BigDecimal.RoundingMode

/**
 * Created by clelio on 18/04/15.
 */
class BankAccount(var ammount: Double = 0.0) {


  private def interest = ammount * percentage;

  def showAmmount = {
    val ammountWithInterest = calculateAmmountWithInterest()
    "£" + BigDecimal(ammountWithInterest).setScale(2, RoundingMode.HALF_UP)
  }

  def calculateAmmountWithInterest() = ammount + interest

  def percentage = if (ammount > 1 && ammount <= 1000) 0.01
    else if (ammount > 1000 && ammount <= 2000) 0.02
    else 0.03


}
