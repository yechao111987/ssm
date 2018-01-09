package scala



import scala.beans.BeanProperty


class ScalaDemo

object ScalaDemo1 {
  def main(args: Array[String]): Unit = {
    println("Scala Demo")
  }
}

class User {
  @BeanProperty var uid: String = _ //
  @BeanProperty var name: String = _
  //
  @BeanProperty var password: String = _
  //
  @BeanProperty var phone: String = _
  //
  @BeanProperty var address: String = _ //
}
