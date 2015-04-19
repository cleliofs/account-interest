package main.scala

/**
 * Created by clelio on 18/04/15.
 */
class Account() {

  def percentage = {
    if (_ammount > 1 && _ammount <= 1000) 0.01
  }


  private var _ammount: Double = 0;

  def ammount = _ammount;

  def ammount_= (value: Double) { _ammount = value};

}
