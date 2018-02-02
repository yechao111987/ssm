package scala


import yechao.model.Customer

import scala.beans.BeanProperty


class ScalaDemo

object ScalaDemo1 {
  def main(args: Array[String]): Unit = {
    println("Scala Demo")
  }
}

class UserScala {
  @BeanProperty var uid: String = _ //
  @BeanProperty var name: String = _
  //
  @BeanProperty var password: String = _
  //
  @BeanProperty var phone: String = _
  //
  @BeanProperty var address: String = _ //
}

class CustomerScala {
  @BeanProperty var cid: Integer = _ //
  @BeanProperty var name: String = _
  //
  @BeanProperty var address: String = _
  //
  @BeanProperty var phone: String = _
  //
}

class CustomerFormScala {
  @BeanProperty var name: String = _
  //
  @BeanProperty var address: String = _
  //
  @BeanProperty var phone: String = _

}

class PageFormTest {
  @BeanProperty var pageNum: Integer = _
  //
  @BeanProperty var pageSize: Integer = _ //
  @BeanProperty var totalPage: Integer = _ //
  @BeanProperty var totalCount: Integer = _ //
}





