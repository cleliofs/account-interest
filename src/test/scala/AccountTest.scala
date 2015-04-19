package test.scala

import main.scala.{BankAccount, Account}
import org.scalatest.FlatSpec

/**
 * Created by clelio on 18/04/15.
 */
class AccountTest extends FlatSpec {

  "An Account" should "contain a stored ammount" in {
    val a = new BankAccount();
    a.ammount = 50.00;
    assert(50.00==a.ammount)

    a.ammount = 150.00;
    assert(150.00==a.ammount, a.ammount)
  }

  "An Account" should "return a percent of 1% when ammount - £1 to £1000" in {
    val a = new BankAccount();
    a.ammount = 100.00;
    assert(0.01 == a.percentage, a.percentage);

    a.ammount = 150.00;
    assert(0.01 == a.percentage)
  }

  "An Account" should "return a percent of 2% when ammount - £1000.01 to £2000" in {
    val a = new BankAccount();
    a.ammount = 1000.01;
    assert(0.02 == a.percentage);

    a.ammount = 2000.00;
    assert(0.02 == a.percentage);
  }

  "An Account" should "return a percent of 3% when ammount - > £2000" in {
    val a = new BankAccount();
    a.ammount = 2000.01;
    assert(0.03 == a.percentage, a.percentage);
  }

  "An Account" should "apply percent on ammount" in {
    val a = new BankAccount();
    a.ammount = 200.00;
    assert(202.00==a.calculateAmmountWithInterest(), a.calculateAmmountWithInterest())

    a.ammount = 250.00;
    assert(252.50==a.calculateAmmountWithInterest(), a.calculateAmmountWithInterest())

    a.ammount = 3000.00;
    assert(3090.00==a.calculateAmmountWithInterest(), a.calculateAmmountWithInterest())
  }

  "An Account" should "show the ammount with interest" in {
    val a = new BankAccount();
    a.ammount = 2050.00;
    assert(0.03==a.percentage, a.percentage)

    assert("£2111.50"==a.showAmmount)

    a.ammount = 3550.00;
    assert("£3656.50"==a.showAmmount)
  }

  "A Set" should "contain not duplicates" in {
    val s = Set(1, 2, 3, 4, 5, 2, 1);
    assert(false==s.contains(7))
    assert(true==s.contains(3))
    assert(5==s.size, s.size)

    val s2 = Set("a", "b")
    assert(2==s2.size)
    assert(false==s2.contains("A"))
  }


  "A List" must "assure the same order of items" in {
    val l = List(2, 1, 3, 4, 5, 1, 2)
    assert(1==l(1))
    assert(4==l(3))
    assert(7==l.length)
    l.map(println)
  }

  "A Tuple" must "work accounrdinly" in {
    val t = ("clelio", "De Souza", "Feitosa");
    assert("clelio"==t._1)
    assert("De Souza"==t._2)
  }

  "A Map" should "contain keys and items" in {
    val m = Map((1, "De Souza"), (2, "Sato"))
    println(m(1))
    println(m(2))
  }
}
